package com.wxp.customer.job;

import com.wxp.customer.common.HttpUtils;
import com.wxp.customer.common.constants.JobConstants;
import com.wxp.customer.config.PropertyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 用户信息更新job
 * @author: wxp
 * @time: 2022/4/7 21:38
 */
@Component
public class UserInfoRefreshJob {

    @Autowired
    RestTemplate restTemplate;


    @Schedules({
            @Scheduled(cron = "10/10 * * * * ? ")
    })
    public void userInfoRefreshJob(){
        Map<String,String> requestMap = new HashMap<>();
        requestMap.put("userId","id1000");
        requestMap.put("bankAccNo","1000");

        String serveUrl = PropertyConfig.getPropertyFromProps(JobConstants.REMOTE_PROVIDER_HOST);
        String invokeUrl = PropertyConfig.getPropertyFromProps(JobConstants.USER_INFO_REFRESH_JOB_INVOKE_URL);

        Object obj = restTemplate.getForObject(HttpUtils.getUrl(serveUrl+invokeUrl,requestMap),String.class);
        if(obj == null){
            return;
        }
        System.out.println("\r\n\n\n\n\n" + obj + "\n\n\n\n\n\n\n\n\n");
    }

}
