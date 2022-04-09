package com.wxp.mix.common.vo;

/**
 * @description: 配置VO
 * @author: wxp
 * @time: 2022/4/8 23:03
 */
public class PropertyVO {
    /**
     * 配置的key
     */
    private String key;
    /**
     * 配置的value
     */
    private String value;
    /**
     * 配置描述
     */
    private String desc;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
