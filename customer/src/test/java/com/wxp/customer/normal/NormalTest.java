package com.wxp.customer.normal;

import com.google.common.reflect.TypeToken;
import com.wxp.customer.common.constants.CommonConstants;
import com.wxp.customer.common.vo.PropertyVO;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @description:
 * @author: wxp
 * @time: 2022/4/8 23:18
 */
public class NormalTest {
    public static void main(String[] args) {
        String str = "[{\n" +
                "  \"key\": \"user.info.refresh.job.crons\",\n" +
                "  \"value\": \"10/10 * * * * ?\",\n" +
                "  \"desc\": \"userInfo刷新任务运行表达式\"\n" +
                "},{\n" +
                "  \"key\": \"user.info.refresh.job.fixedDelay\",\n" +
                "  \"value\": \"100000\",\n" +
                "  \"desc\": \"userInfo任务运行完之后延迟多久再次运行\"\n" +
                "},{\n" +
                "  \"key\": \"remote.provider.hosts\",\n" +
                "  \"value\": \"PROVIDER-ACCOUNT-2\",\n" +
                "  \"desc\": \"服务提供方主机名\"\n" +
                "}\n" +
                "]";
        Type type = new TypeToken<List>(){}.getType();
//            List list = Constants.GSON.fromJson(fr,List.class);
        List<PropertyVO> list = CommonConstants.GSON.fromJson(str, type);
        System.out.println(list);
    }
}
