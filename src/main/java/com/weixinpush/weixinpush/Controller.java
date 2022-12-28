package com.weixinpush.weixinpush;

import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    PushDailyWechatImpl pushDailyWechat;

    @GetMapping("/test")
    public String test()  {
        try {
            pushDailyWechat.pushWechat();
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
