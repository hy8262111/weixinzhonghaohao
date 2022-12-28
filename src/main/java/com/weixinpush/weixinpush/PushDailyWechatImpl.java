package com.weixinpush.weixinpush;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PushDailyWechatImpl {

//    public static void main(String[] args) throws Exception {
//        pushWechat();
//    }

    public void pushWechat() throws WxErrorException {

        //获取access_token
        String token = HttpUtil.createGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx4c575cb630c62944&secret=7f43b31e5c659cd5084cad148d76c2d0").execute().body();
        Map map = JSON.parseObject(token, Map.class);
        String access_token = (String) map.get("access_token");

        //获取公众号所有人
        String body = HttpUtil.createGet("https://api.weixin.qq.com/cgi-bin/user/get?access_token=" + access_token + "&next_openid=").execute().body();
        JsonRootBean jsonRootBean = JSON.parseObject(body, JsonRootBean.class);
        List<String> openid = jsonRootBean.getData().getOpenid();

        for (String s : openid) {
            wechatData(s, "wafIPt2S-K238pNFU0libpI_253S0_4r-P5jZxOTfR8");
        }

    }


    private void wechatData(String wechatId, String templateId) throws WxErrorException {
// 创建配置信息
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId("wx4c575cb630c62944");
        wxStorage.setSecret("7f43b31e5c659cd5084cad148d76c2d0");
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
// 创建模板信息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(wechatId)
                .templateId(templateId)
                .build();

// 获取天气预报信息
        String body = HttpUtil.createGet("https://api.map.baidu.com/weather/v1/?district_id=110100&data_type=all&ak=L9iWKTUfkTXIlRIk439bIq8Fg6cMsnGe").execute().body();
        JsonRootBean2 jsonRootBean2 = JSON.parseObject(body, JsonRootBean2.class);

        String text = jsonRootBean2.getResult().getNow().getText();
        String high = String.valueOf(jsonRootBean2.getResult().getForecasts().get(0).getHigh());
        String low = String.valueOf(jsonRootBean2.getResult().getForecasts().get(0).getLow());
        String s = jsonRootBean2.getResult().getLocation().getCity();


// 获取彩虹屁

        String body2 = HttpUtil.createGet("https://apis.tianapi.com/tiangou/index?key=9ae7b295f4a45eda9c1776b9668ab80e").execute().body();
        JsonRootBean3 jsonRootBean3 = JSON.parseObject(body2, JsonRootBean3.class);

// 获取每日一句
        String body3 = HttpUtil.createGet("https://apis.tianapi.com/everyday/index?key=9ae7b295f4a45eda9c1776b9668ab80e").execute().body();
        JsonRootBean3 jsonRootBean4 = JSON.parseObject(body3, JsonRootBean3.class);


// 封装模板数据
        Date d = new Date();
        //Full格式的日期格式器对象
        DateFormat fullf = DateFormat.getDateInstance(DateFormat.FULL);

        templateMessage.addData(new WxMpTemplateData("now", fullf.format(d), "#FFB6C1"));
        templateMessage.addData(new WxMpTemplateData("city", s, "#B95EA6"));
        templateMessage.addData(new WxMpTemplateData("text", text, "#173177"));
        templateMessage.addData(new WxMpTemplateData("high", high, "#87cefa"));
        templateMessage.addData(new WxMpTemplateData("low", low, "#FF6347"));
        templateMessage.addData(new WxMpTemplateData("scq_day", "2", "#FF1493"));
        templateMessage.addData(new WxMpTemplateData("daily_english_cn", jsonRootBean3.getResult().getContent(), "#800080"));
        templateMessage.addData(new WxMpTemplateData("daily_english_en", jsonRootBean4.getResult().getContent(), "#FFA500"));
        wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
    }


}
