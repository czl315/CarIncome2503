package game.dto;

/**
 * 卡牌json,旅法师营地
 *
 * @author chenzhilong
 * @date 2020/8/1
 */
public class CardLvFaShi {
    /**
     * id
     */
    private Long id;
    /**
     * code
     */
    private String code;
    /**
     * 名称
     */
    private String cname;
    /**
     * "ename": "Hozen Roughhouser",
     */
    private String ename;
    /**
     * 卡牌描述
     */
    private String description;
    /**
     * 规则
     */
    private String rule;
    /**
     * 卡牌类型
     */
    private String cardType;
    /**
     * 稀有度
     */
    private String rarity;
    /**
     * 职业
     */
    private String cardClass;


    /**
     * 随从类型:"race": "海盗",
     */
    private String race;
    /**
     * "clazz": "随从",
     */
    private String clazz;
    /**
     * 法力消耗 "mana": 3,
     */
    private String mana;
    /**
     * 攻击力
     */
    private String attack;
    /**
     * 生命值
     */
    private String hp;
    /**
     * "faction": "Neutral",
     */
    private String faction;

    /**
     * 关键字
     */
    private String legacyKeywords;

    /**
     * "seriesName": "行旅旅行社",
     */
    private String seriesName;

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getLegacyKeywords() {
        return legacyKeywords;
    }

    public void setLegacyKeywords(String legacyKeywords) {
        this.legacyKeywords = legacyKeywords;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getMana() {
        return mana;
    }

    public void setMana(String mana) {
        this.mana = mana;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getCardClass() {
        return cardClass;
    }

    public void setCardClass(String cardClass) {
        this.cardClass = cardClass;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }
}
