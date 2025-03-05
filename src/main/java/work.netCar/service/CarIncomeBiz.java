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
//        updateMinutes(date);//更新用时分钟
//        saveIncomeByDiDi(plat);
        saveIncomeByYangGuang("阳光");
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
                    "" +//7
                    "" +//6
                    "16:09\n" +
                    "入\n" +
                    "我的行程\n" +
                    "全部订单~\n" +
                    "2025年2月▼\n" +
                    "02月28日\n" +
                    "快车 00:00:49\n" +
                    "无责|乘客取消\n" +
                    "北京大兴国际机场P1停车楼(计时)\n" +
                    "万源东里71栋\n" +
                    "已空驶补偿\n" +
                    "接机单\n" +
                    "快车 00:01:57\n" +
                    "已支付\n" +
                    "大兴机场-P1停车楼-1M夹层01-03\n" +
                    "号上车点\n" +
                    "融创公园壹号-西门\n" +
                    "接机单\n" +
                    "68.44元\n" +
                    "快车 22:44:43\n" +
                    "平台已垫付\n" +
                    "大兴机场-P1停车楼-1M夹层04-\n" +
                    "06号上车点\n" +
                    "大兴区河马公舍(西红门店)\n" +
                    "接机单\n" +
                    "94.76元\n" +//5
                    "拼车 21:46:14\n" +
                    "已支付\n" +
                    "瀛海地铁站C口\n" +
                    "敬贤家园北里B区1号楼\n" +
                    "含1个订单\n" +
                    "44.72元\n" +
                    "拼车 21:07:37\n" +
                    "平台已垫付\n" +
                    "瀛海地铁站A口\n" +
                    "南海家园五里-东门\n" +
                    "优先接拼车单\n" +
                    "含2个订单\n" +
                    "15.04元\n" +
                    "快车 09:37:19\n" +
                    "已支付\n" +
                    "南庭新苑北区-北门\n" +
                    "北京友谊医院门诊楼(西城院区)\n" +
                    "29.43元\n" +
                    "拼车 09:08:50\n" +
                    "已支付\n" +
                    "文锦苑西区-东门\n" +
                    "星光影视园A座\n" +
                    "优先接拼车单\n" +
                    "含1个订单\n" +
                    "15.90元\n" +
                    "血\n" +
                    "口\n" +
                    "入\n" +//4
                    "16:08\n" +
                    "co.\n" +
                    "入\n" +
                    "我的行程\n" +
                    "全部订单→\n" +
                    "2025年2月1\n" +
                    "快车 08:53:52\n" +
                    "已支付\n" +
                    "金鼎欣盛家园中区-西门\n" +
                    "首农东方供应链\n" +
                    "15.14元\n" +
                    "快车 07:52:33\n" +
                    "已支付\n" +
                    "星光里北区-西门\n" +
                    "中建大兴之星-东门\n" +
                    "23.32元\n" +
                    "02月27日\n" +
                    "拼车 21:59:08\n" +
                    "已支付\n" +
                    "北京亦创国际会展中心-西1门\n" +
                    "回民胡同24号院\n" +
                    "优先接拼车单\n" +
                    "含2个订单\n" +
                    "70.97元\n" +
                    "快车 21:37:30\n" +
                    "已支付\n" +
                    "瀛海地铁站A口\n" +
                    "金域东郡-东门\n" +
                    "13.12元\n" +
                    "快车 21:08:15\n" +
                    "已支付\n" +
                    "瀛海地铁站A口\n" +
                    "振东五金建材\n" +
                    "16.49元\n" +
                    "入\n" +//3
                    "拼车 18:40:24\n" +
                    "无责|乘客取消\n" +
                    "瀛海地铁站C口\n" +
                    "雅居乐京华雅郡\n" +
                    "优先接拼车单\n" +
                    "拼车 18:38:29\n" +
                    "已支付\n" +
                    "瀛海地铁站C口\n" +
                    "和悦华锦1期-北门\n" +
                    "优先接拼车单\n" +
                    "含2个订单\n" +
                    "14.80元\n" +
                    "拼车18:05:44\n" +
                    "已支付\n" +
                    "大族企业湾15号楼B座\n" +
                    "瀛海家园一里逸园-西门\n" +
                    "优先接拼车单\n" +
                    "含3个订单\n" +
                    "24.50元\n" +
                    "快车 17:37:48\n" +
                    "已支付\n" +
                    "瀛海地铁站C口\n" +
                    "龙湖北京亦庄天街\n" +
                    "顺路订单\n" +
                    "13.32元\n" +
                    "目\n" +
                    "口\n" +
                    "入\n" +//2
                    "16:08\n" +
                    "od\n" +
                    "人\n" +
                    "我的行程\n" +
                    "全部订单。\n" +
                    "2025年2月1\n" +
                    "快车 11:18:16\n" +
                    "已支付\n" +
                    "望舒视觉(哈德门广场店)\n" +
                    "青春梦影视产业园\n" +
                    "顺路订单\n" +
                    "36.73元\n" +
                    "拼车09:42:35\n" +
                    "已支付\n" +
                    "南海家园六里-北门\n" +
                    "中国联通北京市分公司数字化部\n" +
                    "优先接拼车单\n" +
                    "含1个订单\n" +
                    "42.05元\n" +
                    "拼车 09:05:39\n" +
                    "已支付\n" +
                    "美巢集团-西北门\n" +
                    "大族广场T1号楼\n" +
                    "优先接拼车单\n" +
                    "含3个订单\n" +
                    "29.43元\n" +
                    "拼车 08:38:35\n" +
                    "已支付\n" +
                    "晋香居刀削面川湘菜(金盛大街星\n" +
                    "宝隆世纪-西门！\n" +
                    "优先接拼车单|\n" +
                    "含3个订单\n" +
                    "23.62元\n" +
                    "02月26日\n" +
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
            String[] passStrArrEquals = {"出发", "门", "口", "[54;", "54", "公司-1号门", "区门诊东北侧",
                    "八", "GO", "人", "目", "入", "四", "v", "<", "血", "心", "门东侧",
                    "途经1地:", "点", "点|", "点！", "店)", "楼", "同", "店）", "上车点)", "点）",
                    "铁站店)", "2门", "层01-10号上车点", "店", "公司", "座上车点)", "诊", "03号上车点", "号上车点", "06号上车点", "10号上车点",
                    "司-东门", "东门", "(STARBUCKS旁)", "Coffee旁)", "司）",
                    "优先接拼车单","优先接拼车单|",
            };
            if (Arrays.asList(passStrArrEquals).contains(row)) {
                continue;
            }
            //处理忽略信息-途径地："途经1地:六铺炕2区38号楼\n" +
            if (row.startsWith("途经1地:")) {
                continue;
            }
            //处理忽略信息："全部订单▼", "全部订单", "全部订单。"全部订单-
            if (row.startsWith("全部订单") && row.length() == 5) {
                continue;
            }
            //处理忽略信息："2025年2月", "2025年1月▼",
            if (row.startsWith("2025年2月") && (row.length() == 7 || row.length() == 8)){
                continue;
            }

            //日期
            if ((row.length() == 4 || row.length() == 5 || row.length() == 6) && row.contains("月") && row.contains("日")) {
                date = parseDate(year, row);
                System.out.println("当前日期:" + date);
            }

            //修正错误信息：优享) 18:32:55
            if ((row.startsWith("优享") && row.length() == 11)) {
                row = row.replace("优享)", "优享");
            }

//            if (row.startsWith("拼车")){
//                System.out.println(row);
//                System.out.println(row.length());
//                System.out.println(row.startsWith("拼车"));
//                System.out.println(row.length() == 10);
//                System.out.println((row.startsWith("拼车") && row.length() == 10));
//            }

            //获取开始时间：快车 16:45:15
            if (row.equals("优享") || row.equals("滴滴特快") || row.equals("快车") || row.equals("特惠") || row.equals("特惠快车")
                    || (row.startsWith("优享") && row.length() == 10)
                    || (row.startsWith("特惠") && row.length() == 10)
                    || (row.startsWith("特惠快车") && row.length() == 12)
                    || (row.startsWith("滴滴特快") && row.length() == 12)
                    || (row.startsWith("快车") && row.length() == 10)
                    || (row.startsWith("快车)") && row.length() == 11)
                    || (row.startsWith("拼车"))
            ) {
                if (entity != null) {
                    entityList.add(entity);//如果记录非空，将数据插入集合
                }

                entity = new CarIncome();

                entity.setFast_type(row);
                //快车 10:49:22
                if ((row.startsWith("优享") && row.length() == 10) || (row.startsWith("优享") && row.length() == 11)
                        || (row.startsWith("特惠") && row.length() == 10)
                        || (row.startsWith("快车") && row.length() == 10)
                ) {
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
                //拼车21:46:19
                if ((row.startsWith("拼车") && row.length() == 10)) {
                    entity.setFast_type(row.substring(0, 2));
                    row = row.substring(2);
                }
                //拼车)08:55:19
                if ((row.startsWith("拼车)") && row.length() == 11)) {
                    row = row.replace(")", "");
                    entity.setFast_type(row.substring(0, 2));
                    row = row.substring(2);
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

            //含2个订单     1]含1个订单
            if ((row.startsWith("含") || row.startsWith("1]含")) && row.endsWith("个订单")) {
                String count = row.replace("含", "").replace("1]", "").replace("个订单", "");
                int orderCount = Integer.valueOf(count);
                entity.setNum_order(orderCount);
                continue;
            }

            String[] stateStr = {"已完成", "已支付", "平台已垫付", "未支付", "无责已关闭", "已空驶补偿", "无责乘客取消", "核实中乘客取消", "无责乘客取消", "有责乘客取消", "无责已关闭", "已关闭", "有责已关闭", "核实中已关闭"};
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
                    "2025-02-28\n" +
                    "即时\n" +
                    "顺\n" +
                    "已完成\n" +
                    "13:18\n" +
                    "北京新发地汽车交易市场-北1门\n" +
                    "国家药品监督管理局行政受理服...\n" +
                    "25294QSRBDWX4DX\n" +
                    "复制\n" +
                    "客服助手\n" +
                    "￥23.85\n" +
                    "即时\n" +
                    "顺\n" +
                    "已完成\n" +
                    "11:59\n" +
                    "丰乐汇汤泉生活馆-入口\n" +
                    "百乐福·健康生活（丰台木樨园店）\n" +
                    "25294PMG17WX4F9\n" +
                    "复制\n" +
                    "￥11.50\n" +//9
                    "0:34\n" +
                    "我的行程\n" +
                    "改派记录\n" +
                    "默认日期\n" +
                    "已完成\n" +
                    "2025-02-28\n" +
                    "即时\n" +
                    "顺\n" +
                    "已完成\n" +
                    "11:13\n" +
                    "北京博爱医院（B门)\n" +
                    "北京华生康复医院\n" +
                    "25294P0TFRWX4F8\n" +
                    "复制\n" +
                    "￥21.20\n" +
                    "即时\n" +
                    "顺\n" +
                    "已完成\n" +
                    "10:38\n" +
                    "汉庭酒店（北京前门天坛西门店）...\n" +
                    "草桥-地铁站\n" +
                    "252940MG5WWX4FB\n" +
                    "复制\n" +
                    "￥22.71\n" +
                    "客服助手\n" +
                    "即时\n" +
                    "顺\n" +
                    "已完成\n" +
                    "08:26\n" +
                    "敬贤里-北门\n" +
                    "中国石化三元西磁加油站北（黄马...\n" +
                    "25294MSB3XWX4F0\n" +
                    "复制\n" +
                    "￥20.57\n" +//8
                    "0:34\n" +
                    "丿\n" +
                    "54\n" +
                    "我的行程\n" +
                    "改派记录\n" +
                    "默认日期\n" +
                    "已完成\n" +
                    "2025-02-27\n" +
                    "即时\n" +
                    "顺\n" +
                    "已完成\n" +
                    "23:20\n" +
                    "华贸公寓-4号商务楼\n" +
                    "次渠嘉园一区\n" +
                    "25294JMZRNWX4G4\n" +
                    "复制\n" +
                    "￥49.13\n" +
                    "即时\n" +
                    "顺\n" +
                    "已完成\n" +
                    "12:06\n" +
                    "清乐园小区-北门\n" +
                    "丰渔福乌苏里江灶台鱼村\n" +
                    "25294BFEDGWX4F3\n" +
                    "复制\n" +
                    "￥12.61\n" +
                    "客服助手\n" +
                    "2025-02-26\n" +
                    "即时\n" +
                    "顺\n" +
                    "已完成\n" +
                    "13:26\n" +
                    "瀛海家园一里逸园（西门)\n" +
                    "京德尚品酒店（北京大兴国际机场…..\n" +
                    "25293YCJLSWX4F1\n" +
                    "复制\n" +
                    "￥10.85\n" +//7
                    "0:34\n" +
                    "我的行程\n" +
                    "改派记录\n" +
                    "默认日期\n" +
                    "已完成\n" +
                    "2025-02-26\n" +
                    "即时\n" +
                    "顺\n" +
                    "已完成\n" +
                    "13:01\n" +
                    "地铁高米店南站-公交站\n" +
                    "北京秦镜科技有限公司（司法鉴定...\n" +
                    "25293Y1HDUWX4DP\n" +
                    "复制\n" +
                    "￥11.50\n" +
                    "即时\n" +
                    "顺\n" +
                    "已完成\n" +
                    "00:09\n" +
                    "阿尔法棋牌俱乐部（华威店)\n" +
                    "其鑫奥迪奔驰宝马捷豹路虎专修（...\n" +
                    "25293S2UPGWX4FF\n" +
                    "复制\n" +
                    "￥27.19\n" +
                    "客服助手\n" +
                    "2025-02-25\n" +
                    "即时\n" +
                    "顺\n" +
                    "已完成\n" +
                    "23:13\n" +
                    "新濠汇量贩式KTV（通厦店）\n" +
                    "中国传媒大学-西门\n" +
                    "25293RMW5CWX4GH\n" +
                    "复制\n" +
                    "￥12.66\n" +//6
                    "0:33\n" +
                    "丿\n" +
                    "我的行程\n" +
                    "改派记录\n" +
                    "默认日期\n" +
                    "已完成\n" +
                    "2025-02-25\n" +
                    "即时\n" +
                    "顺\n" +
                    "已完成\n" +
                    "12:05\n" +
                    "德惠大厦-沿街停车场南侧\n" +
                    "金隅金麟府\n" +
                    "25293J0S0DWX4FC\n" +
                    "复制\n" +
                    "￥33.72\n" +
                    "即时\n" +
                    "顺\n" +
                    "已完成\n" +
                    "11:12\n" +
                    "花筑·和园四合院轻奢酒店（北京..\n" +
                    "紫书宝-东门\n" +
                    "252931HZAZWX4G2\n" +
                    "复制\n" +
                    "￥19.52\n" +
                    "客服助手\n" +
                    "2025-02-24\n" +
                    "即时\n" +
                    "顺\n" +
                    "已完成\n" +
                    "23:42\n" +
                    "和悦华锦北区1号楼-南门-南侧\n" +
                    "北京京德尚品国际酒店\n" +
                    "25293DGDC4WX4F4\n" +
                    "复制\n" +
                    "￥18.48\n" +//5
                    "0:33\n" +
                    "我的行程\n" +
                    "改派记录\n" +
                    "默认日期\n" +
                    "已完成\n" +
                    "2025-02-24\n" +
                    "即时\n" +
                    "顺\n" +
                    "已完成\n" +
                    "10:58\n" +
                    "北京市房山区人民法院\n" +
                    "七里庄（地铁站)\n" +
                    "252934E7ZNWX4D4\n" +
                    "复制\n" +
                    "￥37.00\n" +
                    "2025-02-23\n" +
                    "即时\n" +
                    "已完成\n" +
                    "23:30\n" +
                    "瀛海地铁站C西南口\n" +
                    "正商杏海苑北苑\n" +
                    "25292XTNV4WX4F1\n" +
                    "复制\n" +
                    "￥11.02\n" +
                    "客服助手\n" +
                    "即时\n" +
                    "顺\n" +
                    "已完成\n" +
                    "22:50\n" +
                    "龙湖北京亦庄天街-1号门\n" +
                    "葛府牛一锅鲜切牛肉自助火锅\n" +
                    "25292XHMOBWX4F4\n" +
                    "¥16.59\n" +//4
                    "0:32\n" +
                    "我的行程\n" +
                    "改派记录\n" +
                    "默认日期\n" +
                    "已完成\n" +
                    "2025-02-23\n" +
                    "即时\n" +
                    "已完成\n" +
                    "21:52\n" +
                    "京门老爆三（旧宫店)-西侧\n" +
                    "大兴区旧宫工业园区（旧头路南15...\n" +
                    "25292WPV4PWX4F9\n" +
                    "复制\n" +
                    "￥11.02\n" +
                    "即时\n" +
                    "已完成\n" +
                    "20:55\n" +
                    "瀛海地铁站B2东北口\n" +
                    "亦城亦禧（北门）\n" +
                    "25292VM1STWX4F1\n" +
                    "复制\n" +
                    "￥13.61\n" +
                    "客服助手\n" +
                    "2025-02-22\n" +
                    "即时\n" +
                    "已完成\n" +
                    "23:30\n" +
                    "十八里店乡周庄小区19号院-南…..\n" +
                    "京虎门涮肉·滩羊烤全羊（旧宫旗...\n" +
                    "25292C521JWX4FF\n" +
                    "复制\n" +
                    "￥18.62\n" +//3
                    "0:32\n" +
                    "<\n" +
                    "我的行程\n" +
                    "改派记录\n" +
                    "默认日期\n" +
                    "已完成\n" +
                    "2025-02-22\n" +
                    "即时\n" +
                    "顺\n" +
                    "已完成\n" +
                    "00:01\n" +
                    "麓枫酒店（北京亦庄开发区京东总..\n" +
                    "通州第二医院-公交站\n" +
                    "25291MOPB1WX4FK\n" +
                    "复制\n" +
                    "￥19.11\n" +
                    "2025-02-21\n" +
                    "即时\n" +
                    "已完成\n" +
                    "22:37\n" +
                    "光谷公寓-东北门\n" +
                    "金手指网吧\n" +
                    "客服助手\n" +
                    "25291LJ1ETWX4FK\n" +
                    "复制\n" +
                    "￥17.76\n" +
                    "即时\n" +
                    "顺\n" +
                    "已完成\n" +
                    "10:02\n" +
                    "旗开德胜租车-东北侧\n" +
                    "北京北本科技有限公司\n" +
                    "2529150GEVWX4F1\n" +
                    "复制\n" +
                    "￥14.78\n" +//2
                    "0:32\n" +
                    ".\n" +
                    "我的行程\n" +
                    "改派记录\n" +
                    "默认日期\n" +
                    "已完成\n" +
                    "2025-02-21\n" +
                    "即时\n" +
                    "顺\n" +
                    "已完成\n" +
                    "12:44\n" +
                    "益丰园小区北区7号楼-东侧\n" +
                    "大兴区北京现代艺术学校北100..\n" +
                    "25290PQD80WX4F3\n" +
                    "复制\n" +
                    "￥23.79\n" +
                    "即时\n" +
                    "顺\n" +
                    "已完成\n" +
                    "11:12\n" +
                    "亮厨酒店特色食材（鸿泰天成水产...\n" +
                    "切爷小馆\n" +
                    "2529001WPGWX4DX\n" +
                    "复制\n" +
                    "￥14.59\n" +
                    "客服助手\n" +
                    "2025-02-19\n" +
                    "即时\n" +
                    "已完成\n" +
                    "00:12\n" +
                    "大兴机场-航站楼-1M夹层-P1停...\n" +
                    "北京丰台站（2层东进站口)\n" +
                    "252902DR6QWX4BC\n" +
                    "复制\n" +
                    "￥132.21\n";//1
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
                    "0:25\n" +
                    "55\n" +
                    "我的订单\n" +
                    "垫付规则\n" +
                    "全部订单\n" +
                    "未完成\n" +
                    "待支付\n" +
                    "已支付\n" +
                    "取消/免单\n" +
                    "已完成的订单\n" +
                    "待评价￥21.94\n" +
                    "经济型\n" +
                    "顺路单\n" +
                    "02-27 23:58\n" +
                    "京东总部1号楼D座D1门（1号楼D座上车点）\n" +
                    ">\n" +
                    "亦城亦禧\n" +
                    "0:25\n" +
                    "我的订单\n" +
                    "5\n" +
                    "垫付规则\n" +
                    "全部订单\n" +
                    "未完成\n" +
                    "待支付\n" +
                    "已支付\n" +
                    "取消/免单\n" +
                    "已评价￥17.70\n" +
                    "经济型\n" +
                    "实时\n" +
                    "02-26 22:34\n" +
                    "京东总部2号楼A5门（2号楼A座上车点）\n" +
                    "鹿海园五里-东门\n" +
                    "待评价￥22.32\n" +
                    "经济型\n" +
                    "顺路单\n" +
                    "02-24 23:14\n" +
                    "京东总部1号楼D座D2门（1号楼D座上车点）\n" +
                    "金隅·学府-西门\n" +
                    "待评价￥28.88\n" +
                    "经济型\n" +
                    "顺路单\n" +
                    "02-19 23:07\n" +
                    "京东总部1号楼A座A1门\n" +
                    "京能电建·洺悦湾-北门\n" +
                    "待评价￥14.26\n" +
                    "经济型\n" +
                    "实时\n" +
                    "02-19 22:38\n" +
                    "京东总部1号楼A座A1门\n" +
                    "富力尚悦居C区-西北门\n";
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
