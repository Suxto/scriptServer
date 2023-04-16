package com.scriptServer.myspringmvc.controllers;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.scriptServer.script.service.impl.ScriptServiceImpl;

import java.util.HashMap;

public class ScriptController {

    ScriptServiceImpl scriptService = null;

    //   appid = wxc2345f11e114fddb
//   secret = 64dfa9aac2d102a7e97bb804e3ded428
//    private String getId
    public static String getId(String code) {
        //微信小程序官方接口
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        //接口所需参数
        HashMap<String, Object> requestUrlParam = new HashMap<>();
        //小程序appId
        requestUrlParam.put("appid", "wxc2345f11e114fddb");
        //小程序secret
        requestUrlParam.put("secret", "64dfa9aac2d102a7e97bb804e3ded428");
        //小程序端返回的code
        requestUrlParam.put("js_code", code);
        //默认参数，固定写死即可
        requestUrlParam.put("grant_type", "authorization_code");
        //发送post请求读取调用微信接口获取openid用户唯一标识
        String result = HttpUtil.get(requestUrl, requestUrlParam);
        JSONObject jsonObject = JSONUtil.parseObj(result);
//        String openid = jsonObject.get("openid", String.class);
//        System.out.println(openid);
        return jsonObject.get("openid", String.class);
//        return jsonObject;
    }


}
