package work.netCar.service;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import work.netCar.db.CarIncome;
import utils.AddressUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * 网约车收入服务(业务处理)
 *
 * @author Administrator
 * @date 2023-05-28 00:49
 * 更新记录：
 * 保存订单-美团     2024-10-07
 * 保存订单-曹操     2025-01-07
 */
public class CarIncomeBiz {

    public static void main(String[] args) {
        String plat = "滴滴";//阳光  嘀嗒 首汽  滴滴
        String date = "2025-02-17";
        updateMinutes(date);//更新用时分钟
//        saveIncomeByDiDi(plat);
//        saveIncomeByYangGuang("阳光");
//        saveIncomeByCaoCao("曹操");
//        saveIncomeByShouQi("首汽");
//        saveIncomeByMeiTuan("美团");
//        System.out.println(savePatch( "2025-02-04","哈啰","顺风车",null,1));
//        System.out.println(savePatch( "2025-02-02","线下","线下",null,1));
//        System.out.println(savePatch( date,plat,null,null,1));//阳光  嘀嗒 首汽

//        saveByJianDaoChenKeWuPin(date);
//        int count = 1;
//        System.out.println(savePatch( "2025-01-19",plat,"奖金","感恩红包",1));
        //  主城早峰完单补贴   热区早峰单单补贴 主城午晚峰流水加速     主城热区夜峰单单补贴
        //专属热区完单奖励  特惠专属热区完单奖励   热区多天完单奖励     10.31经海路热区夜高峰补贴
        //免佣卡彩蛋奖励 单单特快卡  双节专属单单特快卡 北京市热区流水+20% 北京市峰期流水+20% 连续签到奖励8   特惠专属冲刺 专属时段完单奖励  特惠专属热区单单奖 雨天膨胀卡
        // 晋级赛王牌加速卡福利流水+20% 晋级赛先锋加速卡福利
        //误工险订单取消责任赔偿金    空驶补偿 收到不顺路补贴  调度无单补偿
        //单单免佣卡 双节专属北京市峰期免佣卡
        //时空红包奖励  随机奖励     感谢红包 感恩红包  社群活动奖励 社群专属趣味答题
        //双旦专属-快车堵车卡 双旦专属时段完单奖励
        //特定时段：奖励日专属早峰流水加速 奖励日专属晚峰流水加速  北京早峰完单补贴奖励日专属 午晚峰完单补贴奖励日专属 晚峰完单补贴奖励日专属 晚峰完单奖励奖励日专属  北京主城早峰完单补贴
        //节日：端午专属雨天膨胀卡
        //特定地点：场站福利月火车站瓜分奖 早高峰热区单单补贴 早高峰热区单单补贴  奖励日专属   北京  大兴国际机场 热区   热区夜峰单单补贴 热区瓜分奖 主城热区夜峰单单补贴
        //区域：东城西城海淀热区专属夜峰单单补贴
        //季节：清凉一夏雨天膨胀卡 高温补贴
        // 北京合规专属奖励早峰完单补贴奖励日专属 您的专属 双证专属早峰完单补贴 专属时段完单奖励 早峰完单补贴 -春节专属    晚峰  夜峰  高峰  早午峰 午晚峰
        //  流水加速 单单补贴
        //  广告：车贴质检奖励   套餐推荐奖励
        //  心里评测填写奖励

//        findListByCondition(date);

        //根据地址，更新区县、村镇
//        updateEndTown(date);
    }


    /**
     * 更新用时分钟:乘客到达后的等单时间+ 获得订单前的等单时间
     */
    private static void updateMinutes(String date) {
        int updateCount = 0;
        CarIncome condition = new CarIncome();
        condition.setDate(date);
        List<CarIncome> rs = CarIncomeService.findListByCondition(condition);
        if (rs != null) {
            for (CarIncome carIncome : rs) {
//                System.out.println(JSON.toJSONString(carIncome));

                //计算用时分钟(区分拼单)
                Integer orderCount = carIncome.getNum_order();
                BigDecimal minutes = handlerMinutes(carIncome);
                if (minutes == null) {
                    System.out.println("用时计算异常！");
                    continue;
                }
                if (orderCount != null && orderCount > 1) {
                    carIncome.setMins_share(minutes);
                    System.out.println("拼单用时：" + minutes);
                } else {
                    System.out.println("用时：" + minutes);
                    carIncome.setMins(minutes);
                }

                //计算-等待订单时间,包括乘客到达后的等单时间、获得订单前的等单时间
                //乘客到达后的等单时间
                BigDecimal timeArrivedWait = handlerMinutesWait(carIncome);
                //获得订单前的等单时间
                BigDecimal timeWaitOrder = handlerTimeWaitOrder(carIncome);
                carIncome.setWait_mins(timeArrivedWait.add(timeWaitOrder));

                updateCount += CarIncomeService.update(carIncome);
            }
        }
        System.out.println("更新个数：" + updateCount);
    }

    /**
     * 计算-等待订单时间（分钟），订单结束后的等待时间：订单结束时间-乘客到达目的地时间
     *
     * @param carIncome 网约车收入
     */
    private static BigDecimal handlerMinutesWait(CarIncome carIncome) {
        if (carIncome == null) {
            return null;
        }
        String endTime = carIncome.getEnd_time();
        BigDecimal arriveTime = carIncome.getArrive_des_time();
        if (arriveTime == null || endTime == null) {
            return null;
        }
        String fgf = ".";
        String fgfSecond = ":";
        String hourEndTime = "0";
        String minuteEndTime = "0";
        String secondEndTime = "30";
        if (endTime.contains(fgf)) {
            fgf = "\\.";//特殊字符分隔符
            String[] arrayEndTime = endTime.split(fgf);
            hourEndTime = arrayEndTime[0];
            minuteEndTime = arrayEndTime[1];

        } else if (endTime.contains(fgfSecond)) {
            String[] arrayEndTime = endTime.split(fgfSecond);
            hourEndTime = arrayEndTime[0];
            minuteEndTime = arrayEndTime[1];
            secondEndTime = arrayEndTime[2];
        }
        BigDecimal hourBegTime = arriveTime.setScale(0, BigDecimal.ROUND_DOWN);
        int hourBegTimeInt = hourBegTime.intValue();
        String minuteBegTimeStr = arriveTime.subtract(hourBegTime).toString().replace("0.", "");
        int minuteBegTimeInt = Integer.parseInt(minuteBegTimeStr);
//            System.out.println("hourBegTimeInt：" + hourBegTimeInt + ";" + "minuteBegTimeInt：" + minuteBegTimeInt);
        int timeMinutesBegTime = hourBegTimeInt * 60 * 60 + minuteBegTimeInt * 60 + Integer.parseInt(secondEndTime);//默认30秒

        int hourEndTimeInt = Integer.parseInt(hourEndTime);
        int minuteEndTimeInt = Integer.parseInt(minuteEndTime);
//            System.out.println("hourEndTimeInt：" + hourEndTimeInt + ";" + "minuteEndTimeInt：" + minuteEndTimeInt);
        int timeMinutesEndTime = hourEndTimeInt * 60 * 60 + minuteEndTimeInt * 60 + 30;

        int minutes = (timeMinutesEndTime - timeMinutesBegTime) / 60;
//            System.out.println("minutes：" + minutes);
        return new BigDecimal("" + minutes);
    }

    /**
     * 获得订单前的等单时间：获得订单时间（实际开始时间）-开始时间
     *
     * @param carIncome 网约车订单
     * @return
     */
    private static BigDecimal handlerTimeWaitOrder(CarIncome carIncome) {
        if (carIncome == null) {
            return new BigDecimal("0");
        }
        String begTime = carIncome.getStart_time();
        String startTimeReal = carIncome.getStart_time_real();
        String fgf = ".";
        String fgfSecond = ":";
        if (begTime == null || startTimeReal == null) {
            return new BigDecimal("0");
        }
        String hourBegTime = "0";
        String minuteBegTime = "0";
        String secondBegTime = "0";
        String hourStartTimeReal = "0";
        String minuteStartTimeReal = "0";
        String secondStartTimeReal = "0";
        startTimeReal = startTimeReal.replace(" ", "");
        if (begTime.contains(fgf) && startTimeReal.contains(fgf)) {
            fgf = "\\.";//特殊字符分隔符
            String[] array = begTime.split(fgf);
            hourBegTime = array[0];
            minuteBegTime = array[1];
            secondBegTime = "30";//默认
            String[] arrayEndTime = startTimeReal.split(fgf);
            hourStartTimeReal = arrayEndTime[0];
            minuteStartTimeReal = arrayEndTime[1];
            secondStartTimeReal = "30";//默认
        } else if (begTime.contains(fgfSecond) && startTimeReal.contains(fgfSecond)) {
            String[] array = begTime.split(fgfSecond);
            hourBegTime = array[0];
            minuteBegTime = array[1];
            secondBegTime = array[2];
            String[] arrayEndTime = startTimeReal.split(fgfSecond);
            hourStartTimeReal = arrayEndTime[0];
            minuteStartTimeReal = arrayEndTime[1];
            secondStartTimeReal = arrayEndTime[2];//默认
        }

        int hourBegTimeInt = Integer.parseInt(hourBegTime);
        int minuteBegTimeInt = Integer.parseInt(minuteBegTime);
        int secondBegTimeInt = Integer.parseInt(secondBegTime);
        int timeMinutesBegTime = hourBegTimeInt * 60 * 60 + minuteBegTimeInt * 60 + secondBegTimeInt;

        int hourEndTimeInt = Integer.parseInt(hourStartTimeReal);
        int minuteEndTimeInt = Integer.parseInt(minuteStartTimeReal);
        int secondEndTimeInt = Integer.parseInt(secondStartTimeReal);
        int timeMinutesEndTime = hourEndTimeInt * 60 * 60 + minuteEndTimeInt * 60 + secondEndTimeInt;

//        int minutes = (timeMinutesEndTime - timeMinutesBegTime) / 60;
        BigDecimal second = new BigDecimal("" + timeMinutesEndTime).subtract(new BigDecimal("" + timeMinutesBegTime));
//            System.out.println("minutes：" + minutes);
        return second.divide(new BigDecimal("60"), 2, RoundingMode.HALF_UP);
    }

    /**
     * 计算用时分钟
     *
     * @param carIncome 网约车收入
     */
    private static BigDecimal handlerMinutes(CarIncome carIncome) {
        if (carIncome == null) {
            return null;
        }
        String begTime = carIncome.getStart_time();
        String endTime = carIncome.getEnd_time();
        String fgf = ".";
        String fgfSecond = ":";
        if (begTime == null || endTime == null) {
            return null;
        }
        String hourBegTime = "0";
        String minuteBegTime = "0";
        String secondBegTime = "0";
        String hourEndTime = "0";
        String minuteEndTime = "0";
        String secondEndTime = "0";
        if (begTime.contains(fgf) && endTime.contains(fgf)) {
            fgf = "\\.";//特殊字符分隔符
            String[] array = begTime.split(fgf);
            hourBegTime = array[0];
            minuteBegTime = array[1];
            secondBegTime = "30";//默认
            String[] arrayEndTime = endTime.split(fgf);
            hourEndTime = arrayEndTime[0];
            minuteEndTime = arrayEndTime[1];
            secondEndTime = "30";//默认
        } else if (begTime.contains(fgfSecond) && endTime.contains(fgfSecond)) {
            String[] array = begTime.split(fgfSecond);
            hourBegTime = array[0];
            minuteBegTime = array[1];
            secondBegTime = array[2];
            String[] arrayEndTime = endTime.split(fgfSecond);
            hourEndTime = arrayEndTime[0];
            minuteEndTime = arrayEndTime[1];
            secondEndTime = arrayEndTime[2];//默认
        }

        int hourBegTimeInt = Integer.parseInt(hourBegTime);
        int minuteBegTimeInt = Integer.parseInt(minuteBegTime);
        int secondBegTimeInt = Integer.parseInt(secondBegTime);
        int timeMinutesBegTime = hourBegTimeInt * 60 * 60 + minuteBegTimeInt * 60 + secondBegTimeInt;

        int hourEndTimeInt = Integer.parseInt(hourEndTime);
        int minuteEndTimeInt = Integer.parseInt(minuteEndTime);
        int secondEndTimeInt = Integer.parseInt(secondEndTime);
        int timeMinutesEndTime = hourEndTimeInt * 60 * 60 + minuteEndTimeInt * 60 + secondEndTimeInt;

//        int minutes = (timeMinutesEndTime - timeMinutesBegTime) / 60;
        BigDecimal second = new BigDecimal("" + timeMinutesEndTime).subtract(new BigDecimal("" + timeMinutesBegTime));
//            System.out.println("minutes：" + minutes);
        return second.divide(new BigDecimal("60"), 2, RoundingMode.HALF_UP);
    }

    /**
     * 保存-根据-滴滴捡到乘客用品-照片字符串
     *
     * @param date 日期
     */
    public static void saveByJianDaoChenKeWuPin(String date) {
//        date = "2023-10-07";
        String oriStr = "";//原始数据字符串
        {
            oriStr = "" +
                    "" +
                    "" +
                    "" +
                    "";
        }

//        System.out.println(oriStr);
        String[] oriStrArr = oriStr.split("\n");
        List<CarIncome> entityList = new ArrayList<>();
        Set<Integer> ids = new HashSet<>();
        CarIncome entity = new CarIncome();
        boolean isStartAddrOk = false;
        boolean isSetAddrEnd = false;
        boolean isOrderBegin = false;//订单是否开始，订单开始标志：快车
        int orderNum = 0;
        for (String row : oriStrArr) {
//            row = row.replace(" ","");
//            if (row.contains("宣武门|新华通讯社-南2门")) {
//                System.out.println(row);
//            }
            row = row.replace(" ", "");
            if (row.equals("快车") || row.equals("特惠")) {
                entity = new CarIncome();
                if (row.equals("快车")) {
                    entity.setPlat("快车");
                } else if (row.equals("特惠")) {
                    entity.setFast_type("特惠快车");
                } else {
                    entity.setPlat(row);
                }
                isOrderBegin = true;
                isStartAddrOk = false;
                isSetAddrEnd = false;
                continue;
            }
            if (!isOrderBegin) {
                continue;//如果订单未开始，跳过
//                if (row.contains("找不到订单点此报备") || row.equals("请您选择想反馈的订单") || row.equals("请选择您想反馈的订单")) {
//                    continue;
//                }
            }
            if (row.startsWith("2023-") || row.startsWith("2024-")) {
                entity.setDate(row.substring(0, 10));
                String time = row;
//                time = time.replace("2023-08-01 ", "");
//                time = time.replace(":", ".");
//                time = time.substring(11, 15);
                time = time.substring(10);
                entity.setId(++orderNum);
//                System.out.println(time);
                entity.setStart_time(time);
                entity.setStart_time_real(time);
                continue;
            } else if (!isStartAddrOk) {
                if (row.startsWith("·")) {
                    row = row.replace("·", "");
                }
                entity.setStart_addr(row);
                isStartAddrOk = true;
                continue;
            } else if (isStartAddrOk && !isSetAddrEnd) {
                if (row.startsWith("·")) {
                    row = row.replace("·", "");
                }
                entity.setEnd_addr(row);
                isSetAddrEnd = true;
                continue;
            } else if (row.equals("已完成") || row.equals("已关闭") || row.equals("进行中")) {
                entity.setState(row);
//                if (ids.contains(orderNum)) {
//                    System.out.println("记录已存在");
//                } else {
                //判断特定日期
                if (StringUtils.isNotBlank(date)) {
                    if (date.equals(entity.getDate())) {
                        ids.add(orderNum);
                        entityList.add(entity);
                    } else {
                        System.out.println("非特定日期不保存：" + date + ":" + entity.getDate());
                    }
                } else {
                    System.out.println("判断特定日期不判定");

                }
//                }

                isStartAddrOk = false;
                isSetAddrEnd = false;
                isOrderBegin = false;
                continue;
            } else {
                if (row.contains("找不到订单点此报备") || row.equals("请您选择想反馈的订单") || row.equals("请选择您想反馈的订单")) {
//                    System.out.println(row);
                    continue;
                }
                System.out.println(row);

            }
//            System.out.print(",");
            System.out.println(row);
        }

        int i = 0;
        for (CarIncome carIncome : entityList) {
            System.out.print(++i + ":");
            System.out.println(JSON.toJSONString(carIncome));
            CarIncomeService.insert(carIncome);
        }
    }

    /**
     * 保存订单-根据我的行程-滴滴
     *
     * @param plat
     */
    public static void saveIncomeByDiDi(String plat) {
        String date = "2025-12-32";
        String year = "2025";
        String oriStr = "";//原始数据字符串
        {
            oriStr = "" +//10
                    "" +//9
                    "" +//8
                    "" +//7
                    "" +//6
                    "" +//5
                    "" +//4
                    "" +//3
                    "" +//2
                    "";//1
        }
        {
            oriStr = "" +//10
                    "" +//9
                    "" +//8
                    "02月17日\n" +
                    "优享22:04:23\n" +
                    "无责|已关闭\n" +
                    "北京市通州区***\n" +
                    "IU酒店(北京亦庄经济开发区科创二街店)\n" +
                    "口\n" +
                    "入\n" +//7
                    "13:50\n" +
                    "人\n" +
                    "我的行程\n" +
                    "全部订单。\n" +
                    "2025年2月▼\n" +
                    "优享 21:56:17\n" +
                    "已支付\n" +
                    "京东总部2号楼B3门（2号楼上车\n" +
                    "北京市通州区***\n" +
                    "14.34元\n" +
                    "快车 21:33:28\n" +
                    "已支付\n" +
                    "京东总部1号楼B3门旗杆(1号楼上\n" +
                    "北京市通州区***\n" +
                    "13.78元\n" +
                    "快车 21:01:39\n" +
                    "已支付\n" +
                    "北京泰德制药-东北门\n" +
                    "北京市通州区***\n" +
                    "18.68元\n" +
                    "快车 20:38:01\n" +
                    "已支付\n" +
                    "瀛海地铁站A口\n" +
                    "北京市大兴区***\n" +
                    "12.43元\n" +
                    "快车 20:26:45\n" +
                    "已支付\n" +
                    "瀛海地铁站A口\n" +
                    "润棠·瀛海\n" +
                    "11.30元\n" +
                    "目\n" +
                    "口\n" +
                    "入\n" +//6
                    "13:50\n" +
                    "人\n" +
                    "我的行程\n" +
                    "全部订单。\n" +
                    "2025年2月▼\n" +
                    "快车 10:22:41\n" +
                    "已支付\n" +
                    "北京市朝阳区***\n" +
                    "北京市朝阳区***\n" +
                    "14.35元\n" +
                    "优享 09:43:29\n" +
                    "已支付\n" +
                    "北京市朝阳区***\n" +
                    "蓝色港湾国际商区-东北1门\n" +
                    "32.90元\n" +
                    "优享 09:14:44\n" +
                    "已支付\n" +
                    "北京市大兴区***\n" +
                    "十八里店麦德考汽车服务\n" +
                    "27.29元\n" +
                    "优享 09:04:33\n" +
                    "已支付\n" +
                    "旧宫地铁站B1口\n" +
                    "北京市大兴区***\n" +
                    "顺路订单\n" +
                    "12.99元\n" +
                    "优享 08:45:53\n" +
                    "已支付\n" +
                    "桔子酒店(北京旧宫店)\n" +
                    "北京市大兴区***\n" +
                    "顺路订单\n" +
                    "14.19元\n" +
                    "目\n" +
                    "口\n" +
                    "入\n" +//5
                    "优享 08:35:09\n" +
                    "无责|乘客取消\n" +
                    "宝辰汽车园-北1门\n" +
                    "北京市大兴区警大路8号\n" +
                    "顺路订单\n" +
                    "优享 08:10:07\n" +
                    "已支付\n" +
                    "北京市大兴区***\n" +
                    "北京市丰台区***\n" +
                    "顺路订单\n" +
                    "23.83元\n" +
                    "优享 08:01:10\n" +
                    "无责|已关闭\n" +
                    "北京市大兴区***\n" +
                    "北京市大兴冈***\n" +
                    "顺路订单\n" +
                    "优享 07:47:46\n" +
                    "已支付\n" +
                    "北京市大兴区***\n" +
                    "旧宫医院流感疫苗接种点\n" +
                    "顺路订单\n" +
                    "19.53元\n" +
                    "四\n" +
                    "口\n" +
                    "入\n" +//4
                    "02月16日\n" +
                    "优享 22:02:39\n" +
                    "已支付\n" +
                    "北京市大兴区***\n" +
                    "北京市大兴区***\n" +
                    "21.90元\n" +
                    "特惠快车 21:29:36\n" +
                    "已支付\n" +
                    "瀛海地铁站C口\n" +
                    "聚亿轩沐悦温泉浴(潼关三区店)\n" +
                    "19.97元\n" +
                    "四\n" +
                    "入\n" +//3
                    "14:54\n" +
                    "入\n" +
                    "我的行程\n" +
                    "全部订单▼\n" +
                    "2025年2月▼\n" +
                    "02月15日\n" +
                    "快车 22:51:12\n" +
                    "已支付\n" +
                    "北京市朝阳区红军营东路北五环汽配城北京龙湖蓝海引擎产业园\n" +
                    "北京市朝阳区***\n" +
                    "62.77元\n" +//2
                    "14:54\n" +
                    "人\n" +
                    "我的行程\n" +
                    "全部订单▼\n" +
                    "2025年2月▼\n" +
                    "优享 21:34:50\n" +
                    "平台已垫付\n" +
                    "欧美汇购物中心东南侧\n" +
                    "北京市昌平区***\n" +
                    "70.48元\n" +
                    "优享21:33:06\n" +
                    "无责|乘客取消\n" +
                    "海淀黄庄北-公交站路北站台\n" +
                    "北京市海淀区***\n" +
                    "优享 21:05:00\n" +
                    "已支付\n" +
                    "尚隐·泉都市生活馆-东门\n" +
                    "北京市中关村中学(双榆树校区)-\n" +
                    "45.88元\n" +
                    "优享 20:22:34\n" +
                    "已支付\n" +
                    "北京市大兴区***\n" +
                    "金通阳光苑南区-东门\n" +
                    "58.96元\n" +
                    "快车 18:04:13\n" +
                    "已支付\n" +
                    "瀛海地铁站C口\n" +
                    "北京亦庄实验中学-北1门\n" +
                    "12.72元\n" +
                    "四\n" +
                    "口\n" +
                    "入\n";//1
        }


//        System.out.println(oriStr);

        String[] oriStrArr = oriStr.split("\n");
        //处理滴滴订单不规则字符
        oriStrArr = handlerDiDiOrderStr(oriStrArr);

        List<CarIncome> entityList = new ArrayList<>();
        Set<Integer> ids = new HashSet<>();
        CarIncome entity = null;
        boolean isStartAddrOk = false;
        boolean isSetAddrEnd = false;
        boolean isOkTime = false;//时间是否处理
        boolean isOkPay = false;//是否支付
        boolean isOrderBegin = false;//订单是否开始，订单开始标志：快车
        int orderNum = 0;
        for (String row : oriStrArr) {
//            row = row.replace(" ","");
//            if (row.contains("宣武门|新华通讯社-南2门")) {
//                System.out.println(row);
//            }
            row = row.replace(" ", "");

            //  处理忽略信息-全匹配
            String[] passStrArrEquals = {"出发", "门", "全部订单▼", "全部订单", "全部订单。", "2025年1月", "2025年1月▼", "口", "[54;", "54", "公司-1号门", "区门诊东北侧",
                    "八", "GO", "人", "目", "入", "四", "v", "<", "血", "心", "门东侧",
                    "途经1地:", "点", "点|", "点！", "店)", "楼", "同", "店）", "上车点)", "点）",
                    "铁站店)", "2门", "层01-10号上车点", "店", "公司", "座上车点)", "诊", "03号上车点", "号上车点", "06号上车点", "10号上车点",
                    "司-东门", "东门","(STARBUCKS旁)","Coffee旁)","司）",
            };
            if (Arrays.asList(passStrArrEquals).contains(row)) {
                continue;
            }
            //处理忽略信息-途径地："途经1地:六铺炕2区38号楼\n" +
            if (row.startsWith("途经1地:")) {
                continue;
            }

            //日期
            if ((row.length() == 4 || row.length() == 5 || row.length() == 6) && row.contains("月") && row.contains("日")) {
                date = parseDate(year, row);
                System.out.println("当前日期:" + date);
            }

            //修正错误信息：优享) 18:32:55
            if((row.startsWith("优享") && row.length() == 11)){
                row = row.replace("优享)","优享");
            }
            //获取开始时间：快车 16:45:15
            if (row.equals("优享") || row.equals("滴滴特快") || row.equals("快车") || row.equals("特惠") || row.equals("特惠快车")
                    || (row.startsWith("优享") && row.length() == 10)
                    || (row.startsWith("特惠") && row.length() == 10)
                    || (row.startsWith("特惠快车") && row.length() == 12)
                    || (row.startsWith("滴滴特快") && row.length() == 12)
                    || (row.startsWith("快车") && row.length() == 10)
                    || (row.startsWith("快车)") && row.length() == 11)
            ) {
                if (entity != null) {
                    entityList.add(entity);//如果记录非空，将数据插入集合
                }

                entity = new CarIncome();

                entity.setFast_type(row);
                //快车 10:49:22
                if ((row.startsWith("优享") && row.length() == 10) || (row.startsWith("优享") && row.length() == 11)
                        || (row.startsWith("特惠") && row.length() == 10) || (row.startsWith("快车") && row.length() == 10)) {
                    entity.setFast_type(row.substring(0, 2));
                    row = row.substring(2);
                }
                if ((row.startsWith("特惠快车") && row.length() == 12)) {
                    entity.setFast_type(row.substring(0, 4));
                    row = row.substring(4);
                }
                //滴滴特快07:53:09
                if ((row.startsWith("滴滴特快") && row.length() == 12)) {
                    entity.setFast_type(row.substring(0, 4));
                    row = row.substring(4);
                }
//                else if (row.equals("特惠")) {
//                    entity.setFast_type("特惠快车");
//                }else{
//                    entity.setPlat(row);
//                }
                //快车)11:59:09
                if ((row.startsWith("快车)") && row.length() == 11)) {
                    entity.setFast_type(row.substring(0, 2));
                    row = row.substring(3);
                }

                isOrderBegin = true;
                isOkTime = false;
                isStartAddrOk = false;
                isSetAddrEnd = false;
            }
            //01月12日16：22:07抢单
            if (row.contains("抢单")) {
                entity.setGrab(row);
                continue;
            }
            if (!isOrderBegin) {
                continue;//如果订单未开始，跳过
//                if (row.contains("找不到订单点此报备") || row.equals("请您选择想反馈的订单") || row.equals("请选择您想反馈的订单")) {
//                    continue;
//                }
            }
            //08:38:14
            if (row.length() == 8 && row.contains(":")) {
                entity.setDate(date);
                entity.setPlat(plat);
                entity.setStart_time(row);
                entity.setStart_time_real(row);
                entity.setId(++orderNum);
                entity.setUPDATE_TIME(new Date());
                entity.setMonth(date.substring(0, 7));
//                System.out.println(time);
                isOkTime = true;
                continue;
            }
//            else if (row.equals("无责乘客取消") || row.equals("无责") || row.equals("乘客取消")|| row.equals("核实中乘客取消")) {
//                entity.setState(row);
//            }

            String[] stateStr = {"已完成", "已支付", "平台已垫付", "未支付", "无责已关闭", "已空驶补偿", "无责乘客取消", "核实中乘客取消", "无责乘客取消", "有责乘客取消","无责已关闭", "已关闭", "有责已关闭","核实中已关闭"};
            if (Arrays.asList(stateStr).contains(row.replace("|", ""))) {
//            if (row.equals("已完成") || row.equals("已支付") || row.equals("平台已垫付") || row.equals("未支付")
//                    || row.equals("无责已关闭") || row.equals("已空驶补偿") || row.equals("无责乘客取消") || row.equals("核实中乘客取消")) {
                String state = entity.getState();
                String state_empty = "空驶补偿";
                if (row.startsWith("已支付") || row.startsWith("平台已垫付") || row.startsWith("未支付")) {
                    entity.setState("已完成");
                } else if (row.equals("已空驶补偿")) {
                    entity.setState(state_empty);
                    entity.setFast_type(state_empty);
                } else if (state != null && state.equals("空驶补偿") && row.equals("无责已关闭")) {
//                    entity.setState("空驶补偿");
                } else {
                    entity.setState(row);
//                    entityList.add(entity);
                }
                continue;
            }

            if (isOkTime && !isStartAddrOk) {
                //  处理忽略信息-全匹配
                String[] passStrArrEqualsAddr = {"已支付", "平台已垫付"};
                if (Arrays.asList(passStrArrEqualsAddr).contains(row)) {
                    continue;
                }

                if (row.startsWith("·")) {
                    row = row.replace("·", "");
                }
                entity.setStart_addr(row);
                isStartAddrOk = true;
                continue;
            } else if (isStartAddrOk && !isSetAddrEnd) {
                if (row.startsWith("·")) {
                    row = row.replace("·", "");
                }
                entity.setEnd_addr(row);
                isSetAddrEnd = true;
                continue;
            } else if (row.equals("优享") || row.equals("快车") || row.equals("特惠快车") || row.equals("滴滴特快") || row.equals("催款")) {
                continue;
            } else if (row.equals("节假日司机服务费5元") || row.equals("节假日司机服务费3元")) {
                continue;
            } else if (row.equals("顺路订单")) {
                entity.setType_way("顺路");
                continue;
            } else if (row.equals("送站单") || row.equals("接站单") || row.equals("送机单") || row.equals("接机单") || row.equals("“接机单")) {
                if (row.equals("“接机单")) {
                    row = row.replace("“", "");
                }
                entity.setType_addr(row);
                continue;
            } else if (row.endsWith("元")) {
                row = row.replace("元", "");
                BigDecimal fare = new BigDecimal(row);
                entity.setFare(fare);

//                entityList.add(entity);

                isStartAddrOk = false;
                isSetAddrEnd = false;
                isOrderBegin = false;
                continue;
            } else {
                if (row.contains("三") || row.equals("我的行程") || row.equals("全部订单、") || row.equals("无责乘客取消")) {
//                    System.out.println(row);
                    continue;
                }
                System.out.println(row);

            }
//            System.out.print(",");
            if (row.contains("三") || row.equals("我的行程") || row.equals("全部订单、") || row.equals("无责乘客取消") || row.equals("无责") || row.equals("乘客取消")) {
//                    System.out.println(row);
                continue;
            }
            System.out.println(row);
        }
        if (entity != null) {
            entityList.add(entity);//最后一条记录，将数据插入集合
        }

        int i = 0;
        for (CarIncome carIncome : entityList) {
            System.out.print(++i + ":");
            System.out.println(JSON.toJSONString(carIncome));
            CarIncomeService.insert(carIncome);
        }
    }


    /**
     * 保存订单-根据我的行程-阳光
     *
     * @param plat 111
     */
    public static void saveIncomeByYangGuang(String plat) {
        String date = "2025-12-32";
        String oriStr = "";//原始数据字符串
        {
            oriStr = "" +//10
                    "" +//9
                    "" +//8
                    "" +//7
                    "" +//6
                    "" +//5
                    "" +//4
                    "" +//3
                    "" +//2
                    "";//1
        }
        {
            oriStr = "" +//10
                    "" +//9
                    "" +//8
                    "" +//7
                    "我的行程\n" +
                    "18:34\n" +
                    "<\n" +
                    "默认日期\n" +
                    "今天\n" +
                    "2025-02-18\n" +
                    "即时\n" +
                    "11:13\n" +
                    "P1停车楼1M夹层04-06号上车点\n" +
                    "智选假日酒店（富力店)\n" +
                    "2528ZRJB7MWX4BC\n" +
                    "改派记录\n" +
                    "已完成▼\n" +
                    "已完成\n" +
                    "复制\n" +
                    "￥95.65\n" +
                    "2025-02-17\n" +
                    "即时\n" +
                    "23:30\n" +
                    "1M夹层-P1停车场4通道\n" +
                    "桔子酒店（北京亦庄桥地铁站店)\n" +
                    "2528ZLTIEFWX4BC\n" +
                    "复制\n" +
                    "已完成\n" +
                    "￥116.72\n" +
                    "客服助手\n" +
                    "即时\n" +
                    "顺\n" +
                    "11:35\n" +
                    "漷马路马驹桥镇史村幼儿园\n" +
                    "蓝天工业园\n" +
                    "2528ZBXX8IWX4FJ\n" +
                    "已完成\n" +
                    "复制\n" +
                    "￥21.58\n" +//6
                    "18:34\n" +
                    "<\n" +
                    "默认日期\n" +
                    "2025-02-17\n" +
                    "即时\n" +
                    "顺\n" +
                    "11:08\n" +
                    "周庄嘉园B区-南门\n" +
                    "史村\n" +
                    "2528ZBK19TWX4FF\n" +
                    "我的行程\n" +
                    "改派记录\n" +
                    "已完成▼\n" +
                    "已完成\n" +
                    "复制\n" +
                    "￥36.27\n" +
                    "2025-02-16\n" +
                    "即时\n" +
                    "22:31\n" +
                    "北空住宅小区-西门\n" +
                    "玉璟园\n" +
                    "2528Z3TWIVWX4F9\n" +
                    "已完成\n" +
                    "复制\n" +
                    "￥20.35\n" +
                    "客服助手\n" +
                    "即时\n" +
                    "22:18\n" +
                    "红星烧烤\n" +
                    "北京福运达汽车维修中心\n" +
                    "2528Z3MB9QWX4F3\n" +
                    "已完成\n" +
                    "复制\n" +
                    "￥13.17\n" +//5
                    "18:34\n" +
                    "<\n" +
                    "默认日期\n" +
                    "2025-02-16\n" +
                    "我的行程\n" +
                    "改派记录\n" +
                    "已完成▼\n" +
                    "即时\n" +
                    "18:53\n" +
                    "德宏景苑西区-东门\n" +
                    "君悦汤生活馆（总店）\n" +
                    "2528YBY8A2WX4F3\n" +
                    "已完成\n" +
                    "复制\n" +
                    "￥15.65\n" +
                    "即时\n" +
                    "顺\n" +
                    "18:32\n" +
                    "亦庄金茂悦南区（东门)\n" +
                    "瀛海（地铁站)\n" +
                    "2528YBIQSDWX4F4\n" +
                    "已完成\n" +
                    "复制\n" +
                    "￥14.06\n" +
                    "客服助手\n" +
                    "2025-02-14\n" +
                    "即时\n" +
                    "顺\n" +
                    "11:22\n" +
                    "汉庭酒店（北京大兴新城金星桥店….\n" +
                    "大兴国际氢能示范区A区-3号楼…..\n" +
                    "2528X9YUYFWX4DP\n" +
                    "复制\n" +
                    "已完成\n" +
                    "￥29.12\n" +//4
                    "18:33\n" +
                    "<\n" +
                    "默认日期\n" +
                    "2025-02-14\n" +
                    "我的行程\n" +
                    "改派记录\n" +
                    "已完成▼\n" +
                    "即时\n" +
                    "顺\n" +
                    "10:42\n" +
                    "北京南站停车场（出口）对面\n" +
                    "北京家园共育科技有限公司\n" +
                    "2528X9H3QGWX4FB\n" +
                    "复制\n" +
                    "已完成\n" +
                    "￥26.41\n" +
                    "2025-02-13\n" +
                    "即时\n" +
                    "12:24\n" +
                    "珠江骏景北区-东门\n" +
                    "北京大红门希尔顿欢朋酒店\n" +
                    "2528WQVIXHWX4F8\n" +
                    "复制\n" +
                    "已完成\n" +
                    "客服助手\n" +
                    "￥18.72\n" +
                    "即时\n" +
                    "11:01\n" +
                    "黄亦路/瀛坤路(路口）西侧\n" +
                    "角门西里晨新园小区\n" +
                    "2528WPLVORWX4F1\n" +
                    "已完成\n" +
                    "复制\n" +
                    "￥23.08\n" +//3
                    "我的行程\n" +
                    "18:33\n" +
                    "<\n" +
                    "默认日期\n" +
                    "2025-02-13\n" +
                    "即时\n" +
                    "10:39\n" +
                    "荣京丽都-东南门-对面\n" +
                    "龙湖北京亦庄天街-东南门\n" +
                    "2528WPB54DWX4F7\n" +
                    "复制\n" +
                    "改派记录\n" +
                    "已完成▼\n" +
                    "已完成\n" +
                    "￥14.32\n" +
                    "2025-02-12\n" +
                    "即时\n" +
                    "顺\n" +
                    "23:01\n" +
                    "天兴居（瀛海店）-对面\n" +
                    "大东社区百合公寓74号楼\n" +
                    "2528WGEYE1WX4F4\n" +
                    "复制\n" +
                    "已完成\n" +
                    "￥36.36\n" +
                    "客服助手\n" +
                    "即时\n" +
                    "22:44\n" +
                    "贵园南里甲区（西北门）\n" +
                    "好景国际创业产业园（西南2门)\n" +
                    "2528WG6CUOWX4F6\n" +
                    "复制\n" +
                    "已完成\n" +
                    "￥13.32\n" +//2
                    "18:33\n" +
                    "<\n" +
                    "默认日期\n" +
                    "2025-02-12\n" +
                    "我的行程\n" +
                    "改派记录\n" +
                    "已完成▼\n" +
                    "即时\n" +
                    "14:32\n" +
                    "瀛海-地铁站-A西北口附近\n" +
                    "北投如郡\n" +
                    "2528W38HILWX4F1\n" +
                    "已完成\n" +
                    "复制\n" +
                    "￥13.11\n" +
                    "即时\n" +
                    "11:54\n" +
                    "瀛海家园一里逸园-东门-上车点\n" +
                    "瀛海[地铁站](A西北口)\n" +
                    "2528W090VWWX4F1\n" +
                    "已完成\n" +
                    "复制\n" +
                    "￥11.84\n" +
                    "客服助手\n" +
                    "即时\n" +
                    "顺\n" +
                    "10:45\n" +
                    "P1停车楼-1M夹层01-03上车点\n" +
                    "珠江帝景E区\n" +
                    "2528VZ4A36WX4BC\n" +
                    "已完成\n" +
                    "复制\n" +
                    "￥76.35\n" +
                    "2025-02-11\n";//1
        }


//        System.out.println(oriStr);
        String[] oriStrArr = oriStr.split("\n");
        List<CarIncome> entityList = new ArrayList<>();
        CarIncome entity = null;
        boolean isStartAddrOk = false;
        boolean isSetAddrEnd = false;
        boolean isOkTime = false;//时间是否处理
        boolean isOrderBegin = false;//订单是否开始，订单开始标志：即时
        int orderNum = 0;
        for (String row : oriStrArr) {
//            row = row.replace(" ","");
//            if (row.contains("宣武门|新华通讯社-南2门")) {
//                System.out.println(row);
//            }
            row = row.replace(" ", "");

            if (row.length() == 10 && row.startsWith("202") && row.contains("-")) {
                //处理日期，格式："2024-02-27"
                date = row;
            }

            if (row.equals("即时")) {
                if (entity != null) {
                    entityList.add(entity);//如果记录非空，将上一条数据插入集合
                }

                entity = new CarIncome();

                entity.setFast_type("经济型");//默认经济型，需要到明细中更改
                isOrderBegin = true;
                isOkTime = false;
                isStartAddrOk = false;
                isSetAddrEnd = false;
                continue;
            }
            if (!isOrderBegin) {
                continue;//如果订单未开始，跳过
//                if (row.contains("我的行程") || row.equals("默认日期") ) {
//                    continue;
//                }
            }

            //处理开始时间和日期，格式："22:24"
            if (row.length() == 5 && row.contains(":")) {
                String startTime = row + ":00";
                entity.setPlat(plat);
                entity.setDate(date);
                entity.setStart_time(startTime);
                entity.setStart_time_real(startTime);
                entity.setId(++orderNum);
                entity.setUPDATE_TIME(new Date());
                entity.setMonth(date.substring(0, 7));
//                System.out.println(time);
                isOkTime = true;
                continue;
            }
//            else if (row.equals("无责乘客取消") || row.equals("无责") || row.equals("乘客取消")|| row.equals("核实中乘客取消")) {
//                entity.setState(row);
//            }
            //处理起点地址,"芳源里丙13号楼西北侧"
            else if (isOkTime && !isStartAddrOk) {
                if (row.startsWith("·")) {
                    row = row.replace("·", "");
                }
                entity.setStart_addr(row);
                isStartAddrOk = true;
                continue;
            } else if (isStartAddrOk && !isSetAddrEnd) {
                //处理起点地址, "北京大兴国际机场航站楼"
                if (row.startsWith("·")) {
                    row = row.replace("·", "");
                }
                entity.setEnd_addr(row);
                isSetAddrEnd = true;
                continue;
            } else if ((row.startsWith("24") || row.startsWith("25")) && row.length() == 15) {
                //  处理订单号："2425BKI6C5WX4F3" 2518B4ZK7IWX4F1
                continue;
            } else if (row.equals("复制") || row.equals("客服助手") || row.equals("改派记录") || row.equals("已完成▼") || row.equals("我的行程")) {
                //  处理忽略信息："复制"、"客服助手"、"改派记录"
                continue;
            } else if (row.equals("顺")) {
                entity.setType_way("顺路");
                continue;
            } else if (row.equals("已完成")) {
                entity.setState(row);
                continue;
            } else if (row.contains("￥")) {
                //处理订单金额："￥60.21"
                row = row.replace("￥", "");
                BigDecimal fare = new BigDecimal(row);
                entity.setFare(fare);

                isStartAddrOk = false;
                isSetAddrEnd = false;
                isOrderBegin = false;
                continue;
            } else {
                if (row.contains("三")) {
//                    System.out.println(row);
                    continue;
                }
                System.out.println(row);

            }
//            System.out.print(",");
            if (row.contains("三") || row.equals("我的行程") || row.equals("全部订单、") || row.equals("无责乘客取消") || row.equals("无责") || row.equals("乘客取消")) {
//                    System.out.println(row);
                continue;
            }
            System.out.println(row);
        }
        if (entity != null) {
            entityList.add(entity);//最后一条记录，将数据插入集合
        }

        int i = 0;
        for (CarIncome carIncome : entityList) {
            System.out.print(++i + ":");
            System.out.println(JSON.toJSONString(carIncome));
            CarIncomeService.insert(carIncome);
        }
    }


    /**
     * 保存订单-根据我的行程-首汽
     *
     * @param plat 平台
     */
    public static void saveIncomeByShouQi(String plat) {
        String year = "2024";
        String date = null;
        String oriStr = "";//原始数据字符串
        {
            oriStr = "" +//10
                    "" +//9
                    "" +//8
                    "" +//7
                    "" +//6
                    "" +//5
                    "" +//4
                    "" +//3
                    "" +//2
                    "";//1
        }
        {
            oriStr = "" +//10
                    "" +//9
                    "" +//8
                    "" +//7
                    "" +//6
                    "" +//5
                    "" +//4
                    "" +//3
                    "" +//2
                    "23:30\n" +
                    "待结算\n" +
                    "我的订单\n" +
                    "已完成\n" +
                    "已取消\n" +
                    "36\n" +
                    "改派记录\n" +
                    "待服务\n" +
                    "12月21日\n" +
                    "BZ241221102347767000207\n" +
                    "即时用车 10:23\n" +
                    "住总万科广场-西1门-对面\n" +
                    "北京市大兴区隆华路\n" +
                    "已完成\n" +
                    "顺路\n" +
                    "￥12\n";//1
        }

//        System.out.println(oriStr);
        String[] oriStrArr = oriStr.split("\n");
        List<CarIncome> entityList = new ArrayList<>();
        Set<Integer> ids = new HashSet<>();
        CarIncome entity = null;
        boolean isStartAddrOk = false;
        boolean isSetAddrEnd = false;
        boolean isOkTime = false;//时间是否处理
        boolean isOkPay = false;//是否支付
        boolean isOrderBegin = false;//订单是否开始，订单开始标志：即时
        int orderNum = 0;
        for (String row : oriStrArr) {
//            row = row.replace(" ","");
//            if (row.contains("宣武门|新华通讯社-南2门")) {
//                System.out.println(row);
//            }
            row = row.replace(" ", "");

            String[] passStrArr = {"我的订单", "待结算", "改派记录", "已完成", "已取消", "待服务", "开发票", "评价乘客", "已评价乘客", "平台已垫付", "<"};//忽略字符
            //"即时用车 10:03\n" +
//            if (row.equals() || row.equals("待结算") || row.equals("改派记录") || row.equals("已完成") || row.equals("已取消") || row.equals("待服务")) {
            if (Arrays.asList(passStrArr).contains(row)) {
                //  处理忽略信息："复制"、"客服助手"、"改派记录"
                continue;
            }
            //  处理忽略信息
            if (row.startsWith("含免佣￥") || row.startsWith("上划查看20")) {
                continue;
            }

            //处理日期，格式：7月9日
            if ((row.length() == 4 || row.length() == 5 || row.length() == 6) && row.contains("月") && row.contains("日")) {
                date = CarIncomeBiz.parseDate(year, row); //处理日期，格式：7月9日
            }

            if (row.startsWith("即时")) {
                //即时接机 即时用车
                if (entity != null) {
                    entityList.add(entity);//如果记录非空，将上一条数据插入集合
                }

                entity = new CarIncome();

                entity.setFast_type("畅享型");//默认经济型，需要到明细中更改
                isOrderBegin = true;
                isOkTime = false;
                isStartAddrOk = false;
                isSetAddrEnd = false;

                //处理开始时间和日期，格式："22:24"
                String startTime = row.substring(4) + ":00";
                entity.setPlat(plat);
                entity.setDate(date);
                entity.setStart_time(startTime);
                entity.setStart_time_real(startTime);
                entity.setId(++orderNum);
                entity.setUPDATE_TIME(new Date());
                entity.setMonth(date.substring(0, 7));
                entity.setState("已完成");
//                System.out.println(time);
                isOkTime = true;
                continue;
            }
            //处理起点地址,"芳源里丙13号楼西北侧"
            else if (isOkTime && !isStartAddrOk) {
                if (row.startsWith("·")) {
                    row = row.replace("·", "");
                }
                entity.setStart_addr(row);
                isStartAddrOk = true;
                continue;
            } else if (isStartAddrOk && !isSetAddrEnd) {
                //处理起点地址, "北京大兴国际机场航站楼"
                if (row.startsWith("·")) {
                    row = row.replace("·", "");
                }
                entity.setEnd_addr(row);
                isSetAddrEnd = true;
                continue;
            } else if (row.startsWith("BZ24")) {
                //  处理订单号："BZ240709102724705004035"
                continue;
            } else if (row.equals("顺") || row.equals("顺路")) {
                entity.setType_way("顺路");
                continue;
            } else if (row.startsWith("￥")) {
                //处理订单金额："￥14.3含免佣￥4.00"
                row = row.replace("￥", "");
                if (row.contains("含免佣")) {
                    row = row.substring(0, row.indexOf("含免佣"));
                }
                BigDecimal fare = new BigDecimal(row);
                entity.setFare(fare);

                continue;
            } else {
                if (row.contains("三")) {
//                    System.out.println(row);
                    continue;
                }
                System.out.println(row);

            }
//            System.out.print(",");
            if (row.contains("三") || row.equals("我的行程") || row.equals("全部订单、") || row.equals("无责乘客取消") || row.equals("无责") || row.equals("乘客取消")) {
//                    System.out.println(row);
                continue;
            }
            System.out.println(row);
        }
        if (entity != null) {
            entityList.add(entity);//最后一条记录，将数据插入集合
        }

        int i = 0;
        for (CarIncome carIncome : entityList) {
            System.out.print(++i + ":");
            System.out.println(JSON.toJSONString(carIncome));
            CarIncomeService.insert(carIncome);
        }
    }

    /**
     * 保存订单-美团
     *
     * @param plat
     */
    public static void saveIncomeByMeiTuan(String plat) {
        String year = "2024";
        String date = null;
        String oriStr = "";//原始数据字符串
        {
            oriStr = "" +
                    "" +
                    "" +
                    "" +
                    "" +
                    "" +
                    "" +
                    "" +
                    "" +
                    "";
        }
        {
            oriStr = "" +
                    "" +
                    "" +
                    "" +
                    "" +
                    "" +
                    "" +
                    "" +
                    "" +
                    "19:01\n" +
                    "<\n" +
                    "全部订单\n" +
                    "订单\n" +
                    "实时单\n" +
                    "预约单\n" +
                    "优质特惠\n" +
                    "三方\n" +
                    "10-0320:23接单\n" +
                    "北京农商银行（瀛海支行)\n" +
                    "中铁华侨城和园-北门\n" +
                    "已完成\n" +
                    "13.99元\n" +
                    "三\n" +
                    "<\n";
        }

//        System.out.println(oriStr);
        String[] oriStrArr = oriStr.split("\n");
        List<CarIncome> entityList = new ArrayList<>();
        Set<Integer> ids = new HashSet<>();
        CarIncome entity = null;
        boolean isStartAddrOk = false;
        boolean isSetAddrEnd = false;
        boolean isOkTime = false;//时间是否处理
        boolean isOkPay = false;//是否支付
        boolean isOrderBegin = false;//订单是否开始，订单开始标志：即时
        int orderNum = 0;
        for (String row : oriStrArr) {
//            row = row.replace(" ","");
//            if (row.contains("宣武门|新华通讯社-南2门")) {
//                System.out.println(row);
//            }
            row = row.replace(" ", "");

            //  处理忽略信息-包含
            String[] passStrArrContarins = {"全部订单", "实时单", "预约单", "<"};//忽略字符
            //"即时用车 10:03\n" +
//            if (row.equals() || row.equals("待结算") || row.equals("改派记录") || row.equals("已完成") || row.equals("已取消") || row.equals("待服务")) {
            if (Arrays.asList(passStrArrContarins).contains(row)) {
                //  处理忽略信息："复制"、"客服助手"、"改派记录"
                continue;
            }
            //  处理忽略信息-全匹配
            String[] passStrArrEquals = {"订单", "三"};
            if (Arrays.asList(passStrArrEquals).contains(row)) {
                continue;
            }

            // 订单开始，首先设置订单类型： "优质特惠\n" +
            String[] fastType = {"优质特惠"};
            if (Arrays.asList(fastType).contains(row)) {
                //上一订单实体如果非空，进入队列
                if (entity != null) {
                    entityList.add(entity);//如果记录非空，将上一条数据插入集合
                }

                entity = new CarIncome();

                entity.setFast_type(row);//订单类型
                isOrderBegin = true;
                isOkTime = false;
                isStartAddrOk = false;
                isSetAddrEnd = false;
                continue;
            }

            // 渠道类型：三方
            String[] channelTypeList = {"三方"};
            if (Arrays.asList(channelTypeList).contains(row)) {
                continue;
            }

            //处理日期，格式："10-0320:23接单\n" +
            if (row.endsWith("接单") && row.length() == 12) {
                row = row.replace("接单", "");

                String dateOri = row.substring(0, 5);
                date = CarIncomeBiz.parseDate(year, dateOri); //处理日期，格式：10-03

                //处理开始时间和日期，格式："22:24"
                String startTime = row.substring(5) + ":00";
                entity.setPlat(plat);
                entity.setDate(date);
                entity.setStart_time(startTime);
                entity.setStart_time_real(startTime);
                entity.setId(++orderNum);
                entity.setUPDATE_TIME(new Date());
                entity.setMonth(date.substring(0, 7));

//                System.out.println(time);
                isOkTime = true;
                continue;
            }
            if (row.equals("已完成")) {
                //订单状态
                entity.setState("已完成");
                continue;
            }
            //处理起点地址,"芳源里丙13号楼西北侧"
            if (isOkTime && !isStartAddrOk) {
                if (row.startsWith("·")) {
                    row = row.replace("·", "");
                }
                entity.setStart_addr(row);
                isStartAddrOk = true;
                continue;
            } else if (isStartAddrOk && !isSetAddrEnd) {
                //处理起点地址, "北京大兴国际机场航站楼"
                if (row.startsWith("·")) {
                    row = row.replace("·", "");
                }
                entity.setEnd_addr(row);
                isSetAddrEnd = true;
                continue;
            }
            //  处理订单号："BZ240709102724705004035"
            else if (row.startsWith("BZ24")) {
                continue;
            } else if (row.equals("顺")) {
                entity.setType_way("顺路");
                continue;
            } else if (row.endsWith("元")) {
                row = row.replace("元", "");
                BigDecimal fare = new BigDecimal(row);
                entity.setFare(fare);

                continue;
            } else {
                // 未知信息，打印出来
                System.out.println(row);
                continue;

            }
        }
        if (entity != null) {
            entityList.add(entity);//最后一条记录，将数据插入集合
        }

        int i = 0;
        for (CarIncome carIncome : entityList) {
            System.out.print(++i + ":");
            System.out.println(JSON.toJSONString(carIncome));
            CarIncomeService.insert(carIncome);
        }
    }


    /**
     * 保存订单-曹操
     *
     * @param plat
     */
    public static void saveIncomeByCaoCao(String plat) {
        String year = "2025";
        String date = null;
        String oriStr = "";//原始数据字符串
        {
            oriStr = "" +
                    "" +
                    "" +
                    "" +
                    "" +
                    "" +
                    "" +
                    "" +
                    "" +
                    "";
        }
        {
            oriStr = "" +
                    "" +
                    "" +
                    "" +
                    "" +
                    "" +
                    "" +
                    "" +
                    "" +
                    "19:35\n" +
                    "个\n" +
                    "全部订单\n" +
                    "未完成\n" +
                    "我的订单\n" +
                    "待支付\n" +
                    "已支付\n" +
                    "垫付规则\n" +
                    "取消/免单\n" +
                    "经济型\n" +
                    "待评价￥92.27\n" +
                    "02-17 22:07\n" +
                    "京东总部1号楼F座F2门（1号楼F座上车点)\n" +
                    "兴业银行（庞各庄支行)\n" +
                    "实时\n" +
                    "经济型\n" +
                    "已取消\n" +
                    "02-16 22:29\n" +
                    "北京市大兴区旧宫镇幻星家园\n" +
                    "北京大兴国际机场航站楼-3F国内出发\n" +
                    "顺路单\n" +
                    "已评价￥15.41\n" +
                    "经济型\n" +
                    "02-12 14:07\n" +
                    "北京市大兴区旧宫镇葛洲坝紧郡府南区（北...\n" +
                    "北京中医药大学东方医院南院区-入口\n" +
                    "顺路单\n" +
                    "已评价￥23.81\n" +
                    "经济型\n" +
                    "顺路单\n" +
                    "02-12 13:37\n" +
                    "双河北里34号楼东侧\n" +
                    "万科广场\n";
        }

//        System.out.println(oriStr);
        String[] oriStrArr = oriStr.split("\n");
        List<CarIncome> entityList = new ArrayList<>();
        Set<Integer> ids = new HashSet<>();
        CarIncome entity = new CarIncome();
        boolean isStartAddrOk = false;
        boolean isSetAddrEnd = false;
        boolean isOkTime = false;//时间是否处理
        boolean isOkPay = false;//是否支付
        boolean isOrderBegin = false;//订单是否开始，订单开始标志：即时
        int orderNum = 0;
        for (String row : oriStrArr) {
//            row = row.replace(" ","");
//            if (row.contains("宣武门|新华通讯社-南2门")) {
//                System.out.println(row);
//            }

            //  处理忽略信息-包含
            String[] passStrArrContarins = {"全部订单", "我的订单", "已完成的订单", ""};//忽略字符
            //"即时用车 10:03\n" +
//            if (row.equals() || row.equals("待结算") || row.equals("改派记录") || row.equals("已完成") || row.equals("已取消") || row.equals("待服务")) {
            if (Arrays.asList(passStrArrContarins).contains(row)) {
                //  处理忽略信息："复制"、"客服助手"、"改派记录"
                continue;
            }
            //  处理忽略信息-全匹配
            String[] passStrArrEquals = {"全部订单", "我的订单", "未完成", "待支付", "已支付", "垫付规则", "取消/免单",
                    "<", "0:47", ">"
            };
            if (Arrays.asList(passStrArrEquals).contains(row)) {
                continue;
            }

            // 订单开始，包含￥，例如：已评价￥22.07
            if (row.startsWith("已评价￥") || row.startsWith("待支付￥") || row.startsWith("待评价￥") || row.startsWith("已取消")) {
                entity = new CarIncome();
                isOrderBegin = true;
                isOkTime = false;
                isStartAddrOk = false;
                isSetAddrEnd = false;

                entity.setPlat(plat);

                //订单状态
                if (row.startsWith("已取消")) {
                    entity.setState("已取消");
                } else {
                    entity.setState("已完成");
                }

                //订单金额
                if (row.contains("￥")) {
                    String price = row.substring(row.indexOf("￥") + 1);
                    BigDecimal fare = new BigDecimal(price);
                    entity.setFare(fare);
                }
                continue;
            }


            //订单类型
            if (row.equals("经济型")) {
                entity.setFast_type(row);
                continue;
            }
            if (row.equals("特价车")) {
                entity.setFast_type("特价车");
                continue;
            }

            //顺路类型："顺路单\n" +
            if (row.equals("顺路单")) {
                entity.setType_way("顺路");
                continue;
            } else if (row.equals("实时")) {
                continue;
            }

            //处理日期，格式："01-03 00:16\n" +
            if (row.length() == 11 && row.substring(2, 3).equals("-")) {
                String dateOri = row.substring(0, 5);
                date = CarIncomeBiz.parseDate(year, dateOri); //处理日期，格式：10-03

                //处理开始时间和日期，格式："22:24"
                String startTime = row.substring(5).trim() + ":00";

                entity.setDate(date);
                entity.setMonth(date.substring(0, 7));
                entity.setStart_time(startTime);
                entity.setStart_time_real(startTime);
                entity.setId(++orderNum);
                entity.setUPDATE_TIME(new Date());

//                System.out.println(time);
                isOkTime = true;
                continue;
            }

            //处理起点地址
            if (isOkTime && !isStartAddrOk) {
                entity.setStart_addr(row);
                isStartAddrOk = true;

                //如果开始地址是机场，地址类型设置为接机单
                if (row.startsWith("大兴机场-航站楼-1M夹层") || row.startsWith("P1停车楼-1M夹层") || row.startsWith("河北省廊坊市广阳区九州镇北京大兴国际")) {
                    entity.setType_addr("接机单");
                }

                continue;
            } else if (isStartAddrOk && !isSetAddrEnd) {
                //处理终点地址
                entity.setEnd_addr(row);
                isSetAddrEnd = true;

                if (entity != null) {
                    entityList.add(entity);//最后一条记录，将数据插入集合
                }

                continue;
            } else {
                // 未知信息，打印出来
                System.out.println(row);
                continue;
            }


        }

        int i = 0;
        for (CarIncome carIncome : entityList) {
            System.out.print(++i + ":");
            System.out.println(JSON.toJSONString(carIncome));
            CarIncomeService.insert(carIncome);
        }

    }


    /**
     * 根据地址，更新村镇
     *
     * @param date
     */
    private static void updateEndTown(String date) {
        int updateCount = 0;
        List<CarIncome> rs = null;
        CarIncome condition = new CarIncome();
        condition.setDate(date);
        List<CarIncome> carIncomeList = CarIncomeService.findListByCondition(condition);
        if (carIncomeList == null) {
            return;
        }
        for (CarIncome carIncome : carIncomeList) {
            String endAddr = carIncome.getEnd_addr();
            if (endAddr == null) {
                continue;
            }
            String addressTown = null;
            String addressCounty = null;
            System.out.print(endAddr);
            System.out.print(":::");
            for (String addr : AddressUtil.BEI_JING_LIST) {
                if (endAddr.contains(addr)) {
                    addressTown = addr;
                }
            }
            System.out.print(addressTown);
            System.out.print(":::");
            addressCounty = AddressUtil.BEI_JING_MAP_TOWN_COUNTY.get(addressTown);
            System.out.print(addressCounty);
            System.out.println();

            CarIncome entity = new CarIncome();
            entity.setId(carIncome.getId());
            entity.setEnd_county(addressCounty);
            entity.setEnd_village(addressTown);
            updateCount += CarIncomeService.update(entity);
        }
        System.out.println("更新地址个数：" + updateCount);
    }


    /**
     * //处理滴滴订单不规则字符:
     * 如果包含：北京市丰台区***北京市大兴区***顺路订单，需要修正为***\n
     *
     * @param oriStrArr
     */
    private static String[] handlerDiDiOrderStr(String[] oriStrArr) {
        List<String> strList = new ArrayList<>();
        for (String row : oriStrArr) {
            //如果包含：北京市丰台区***北京市大兴区***顺路订单，需要修正为***\n
            if (row.contains("***北京市")) {
//                System.out.println("原始字符串：");
//                System.out.println(row);

                String[] newRowArr = row.split("\\*\\*\\*");
                int maxLenth = newRowArr.length;
//                System.out.println("处理后字符串：");
                for (String newRow : newRowArr) {
                    if (--maxLenth != 0) {
                        //最后一位不加,其他需要添加
                        newRow = newRow + "***";
                    }
//                    System.out.println(newRow);
                    strList.add(newRow);
                }
            } else if (row.contains("***顺路订单")) {
                //如果包含：北京市大兴区***顺路订单，需要修正为
//                System.out.println("原始字符串：");
//                System.out.println(row);

                String[] newRowArr = row.split("\\*\\*\\*");
                int maxLenth = newRowArr.length;
//                System.out.println("处理后字符串：");
                for (String newRow : newRowArr) {
                    if (--maxLenth != 0) {
                        //最后一位不加,其他需要添加
                        newRow = newRow + "***";
                    }
//                    System.out.println(newRow);
                    strList.add(newRow);
                }
            } else {
                strList.add(row);
            }
        }
        return strList.toArray(new String[strList.size()]);
    }

    /**
     * 解析日期：格式：7月9日;格式：10-03
     *
     * @param date
     * @return
     */
    public static String parseDate(String year, String date) {
        //处理日期，格式：7月9日
        if ((date.length() == 4 || date.length() == 5 || date.length() == 6) && date.contains("月") && date.contains("日")) {
            String month = date.substring(0, date.indexOf("月"));
            if (month.length() == 1) {
                month = "0" + month;
            }
            String day = date.substring(date.indexOf("月") + 1, date.indexOf("日"));
            if (day.length() == 1) {
                day = "0" + day;
            }
            date = year + "-" + month + "-" + day;
        }

        //处理日期，格式：10-03
        if (date.length() == 5 && date.contains("-")) {
            date = year + "-" + date;
        }

        return date;
    }

    /**
     * 批量保存
     *
     * @param count      个数
     * @param date       日期
     * @param fastType   订单类型
     * @param bonus_type 奖金类型
     * @return rs
     */
    private static int savePatch(String date, String plat, String fastType, String bonus_type, int count) {
        int rs = 0;
        String STATE_FINISH = "已完成";
        for (int i = 0; i < count; i++) {
            CarIncome entity = new CarIncome();
            entity.setDate(date);
            entity.setMonth(date.substring(0, 7));
            entity.setPlat(plat);
            entity.setFast_type(fastType);
            entity.setBonus_type(bonus_type);
            entity.setFare_bounty(new BigDecimal("0"));
            entity.setFare_cost(new BigDecimal("0"));
            entity.setUPDATE_TIME(new Date());
            entity.setState(STATE_FINISH);
            rs += CarIncomeService.insert(entity);
        }
        return rs;
    }

}
