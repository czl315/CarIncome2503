package game;

import com.alibaba.fastjson.JSON;
import game.dto.CardJsonPtLvFaShi;
import game.dto.CardLvFaShi;
import org.apache.commons.lang3.StringUtils;
import utils.HttpUtil;

import java.util.List;

public class LscsUtilLvFaShi {

    public static void main(String[] args) {
        String str = "";
        {
            str = "";
        }

        String pageSize = "200";
        String series = "76";//68-胜地历险记;69-行旅旅行社;70-深谙领域
        String cardClass = "neutral";
        String rsJson = findJsonCard("", cardClass, pageSize, series);
//            System.out.println(rsJson);//返回结果
        String data = JSON.parseObject(rsJson).getString("data");
        CardJsonPtLvFaShi cardJsonPt = JSON.parseObject(data, CardJsonPtLvFaShi.class);
        List<CardLvFaShi> cardJsonList = cardJsonPt.getCards();
        for (CardLvFaShi cardJson : cardJsonList) {
//            System.out.println(JSON.toJSONString(cardJson));
            handlerCardRs(cardJson);
            System.out.println(
                    cardJson.getId() + "\t"
                            + cardJson.getCname() + "\t"
                            + cardJson.getEname() + "\t"
                            + cardJson.getRule().replace("\n", "") + "\t"
                            + cardJson.getRace() + "\t"
                            + cardJson.getClazz() + "\t"
                            + cardJson.getAttack() + "\t"
                            + cardJson.getHp() + "\t"
                            + cardJson.getFaction() + "\t"
                            + cardJson.getMana() + "\t"
                            + cardJson.getRarity() + "\t"
                            + cardJson.getSeriesName() + "\t"
                            + series);
        }


    }

    /**
     * 处理卡牌结果数据
     *
     * @param cardJson
     */
    private static void handlerCardRs(CardLvFaShi cardJson) {
        if (cardJson == null) {
            return;
        }
        if ("minion".equals(cardJson.getCardType())) {
            cardJson.setCardType("随从");
        }
        if ("spell".equals(cardJson.getCardType())) {
            cardJson.setCardType("法术");
        }
        if (StringUtils.isBlank(cardJson.getCardType())) {
            cardJson.setCardType("");
        }

        //职业
        cardJson.setFaction(cardJson.getFaction().replace("Mage", "法师"));
        cardJson.setFaction(cardJson.getFaction().replace("Druid", "德鲁伊"));
        cardJson.setFaction(cardJson.getFaction().replace("Paladin", "圣骑士"));
        cardJson.setFaction(cardJson.getFaction().replace("Warrior", "战士"));
        cardJson.setFaction(cardJson.getFaction().replace("Warlock", "术士"));
        cardJson.setFaction(cardJson.getFaction().replace("Shaman", "萨满"));
        cardJson.setFaction(cardJson.getFaction().replace("Rogue", "潜行者"));
        cardJson.setFaction(cardJson.getFaction().replace("Priest", "牧师"));
        cardJson.setFaction(cardJson.getFaction().replace("Neutral", "中立"));
        cardJson.setFaction(cardJson.getFaction().replace("Hunter", "猎人"));
        cardJson.setFaction(cardJson.getFaction().replace("Demonhunter", "恶魔猎手"));
        cardJson.setFaction(cardJson.getFaction().replace("Deathknight", "死亡骑士"));

        //关键字
//        if(StringUtils.isBlank(cardJson.getCardClass())){
//            if (cardJson.getLegacyKeywords().contains("恶魔猎手")) {
//                cardJson.setCardClass(cardJson.getCardClass()+"恶魔猎手,");
//            }
//            if (cardJson.getLegacyKeywords().contains("德鲁伊")) {
//                cardJson.setCardClass(cardJson.getCardClass()+"德鲁伊,");
//            }
//            if (cardJson.getLegacyKeywords().contains("猎人")) {
//                cardJson.setCardClass(cardJson.getCardClass()+"猎人,");
//            }
//            if (cardJson.getLegacyKeywords().contains("法师")) {
//                cardJson.setCardClass(cardJson.getCardClass()+"法师,");
//            }
//            if (cardJson.getLegacyKeywords().contains("牧师")) {
//                cardJson.setCardClass(cardJson.getCardClass()+"牧师,");
//            }
//            if (cardJson.getLegacyKeywords().contains("圣骑士")) {
//                cardJson.setCardClass(cardJson.getCardClass()+"圣骑士,");
//            }
//            if (cardJson.getLegacyKeywords().contains("潜行者")) {
//                cardJson.setCardClass(cardJson.getCardClass()+"潜行者,");
//            }
//            if (cardJson.getLegacyKeywords().contains("萨满")) {
//                cardJson.setCardClass(cardJson.getCardClass()+"萨满,");
//            }
//            if (cardJson.getLegacyKeywords().contains("术士")) {
//                cardJson.setCardClass(cardJson.getCardClass()+"术士,");
//            }
//            if (cardJson.getLegacyKeywords().contains("战士")) {
//                cardJson.setCardClass(cardJson.getCardClass()+"战士,");
//            }
//        }


        //随从类型
        if (StringUtils.isBlank(cardJson.getRace())) {
            cardJson.setRace("");
        }
        if ("minion".equals(cardJson.getRace())) {
            cardJson.setRace("随从");
        }

        //攻击
        if (StringUtils.isBlank(cardJson.getAttack())) {
            cardJson.setAttack("");
        }
        //生命
        if (StringUtils.isBlank(cardJson.getHp())) {
            cardJson.setHp("");
        }


    }

    /**
     * 查询
     *
     * @param cookie
     * @param size
     * @param series 系列号码
     */
    private static String findJsonCard(String cookie, String cardClass, String size, String series) {
        String url = "https://api2.iyingdi.com/hearthstone/card/search/vertical?ignoreHero=1&series=" + series + "&statistic=total&order=-series%2C%2Bmana&token=&page=0&size=200";
        StringBuffer urlParam = new StringBuffer();
//        urlParam.append("cardClass="+"druid");
//        urlParam.append("&cardClass=" + cardClass +
//                "&p=" + page +
//                "&standard=1" +
//                "&keywords=" +
//                "&t=1596363737564" +
//                "&cardSet=" + cardSet);

        //        System.out.println(rs);
        System.out.println("请求url:" + url + JSON.toJSONString(urlParam));
//        String rs = HttpUtil.sendGet(url, urlParam.toString(), cookie);
        String rs = HttpUtil.sendPost(url, urlParam.toString(), cookie);
//        System.out.println("查询结果：" + rs);
//        System.out.println("fundTradeList:" + JSON.toJSONString(fundTradeList));
        return rs;
    }
}
