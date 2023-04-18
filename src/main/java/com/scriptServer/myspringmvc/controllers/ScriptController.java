package com.scriptServer.myspringmvc.controllers;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.scriptServer.script.bean.Script;
import com.scriptServer.script.service.impl.ScriptServiceImpl;
import com.scriptServer.utils.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class ScriptController {

    ScriptServiceImpl scriptService = null;

    //   appid = wxc2345f11e114fddb
//   secret = 64dfa9aac2d102a7e97bb804e3ded428
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

    private String getAuthorScripts(String author) {
//        scriptService = new ScriptServiceImpl();
        List<Script> list = scriptService.getScripts(null, author);
        JSONArray jsonArray = new JSONArray(list);
//        System.out.println(jsonArray);
//        return null;
        return jsonArray.toString();
    }

    private String getScripts(String title) {
//        scriptService = new ScriptServiceImpl();
        List<Script> list = scriptService.getScripts(title, null);
        JSONArray jsonArray = new JSONArray(list);
//        System.out.println(jsonArray);
//        return null;
        return jsonArray.toString();
    }


    private String getContents(String type, String id) {
        String sql = "SELECT " + type + " FROM contents WHERE id = ?";
        ResultSet resultSet = JDBC.getResultSet(sql, id);
        try {
            if (!resultSet.next()) return null;
            else {
                //                String s = (String) resultSet.getObject(1);
//                System.out.println(s);
                return (String) resultSet.getObject(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        ScriptController scriptController = new ScriptController();
//        System.out.println(scriptController.getAuthorScripts("okSpD5JBx8QC1KNP6KUkE5OBYayA"));
        System.out.println(scriptController.getContents("missions", "1"));
    }
}
