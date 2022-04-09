package com.wxp.customer.common.constants;

import com.google.gson.Gson;

/**
 * @description: 常量类
 * @author: wxp
 * @time: 2022/4/8 22:30
 */
public class CommonConstants {
    /**
     * json转化工具类
     */
    public static final Gson GSON = new Gson();
    /**
     * 配置中心地址
     */
    public static final String CONFIG_CENTER_SERVE_URL = "http://PROVIDER-ACCOUNT-2";

    /**
     * 读取配置接口
     */
    public static final String PROP_REQUEST_BY_PROP_NAME_INVOKE_URL = "/sao/getConsumerPropsByPropName";
}
