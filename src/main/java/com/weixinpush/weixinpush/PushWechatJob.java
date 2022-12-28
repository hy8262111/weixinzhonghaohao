package com.weixinpush.weixinpush;

import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
/**
 * 推送消息到用户定时任务
 */
@Component
public class PushWechatJob {
    @Autowired
    private PushDailyWechatImpl pushDailyWechat;
    /**
     * 每天早上7点推送到微信
     * @throws WxErrorException
     */
    @Scheduled(cron = "0 5 8 1/1 * ? ")
    void  doJob() throws WxErrorException {
        pushDailyWechat.pushWechat();
    }
}
