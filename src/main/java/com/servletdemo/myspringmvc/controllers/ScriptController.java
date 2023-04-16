package com.servletdemo.myspringmvc.controllers;

import com.servletdemo.script.bean.Script;
import com.servletdemo.script.service.impl.ScriptServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.servletdemo.utils.Tools.isEmpty;
import static com.servletdemo.utils.Tools.isnEmpty;

public class ScriptController {

    ScriptServiceImpl scriptService = null;


//    private String index(HttpSession session, String pageNo, String keyword) {
//        if (pageNo == null) pageNo = "1";
//        if (isEmpty(keyword)) keyword = (String) session.getAttribute("keyword");
//        List<Script> list = userService.getUserList(keyword, pageNo);
//        int tot = userService.getPageCount(keyword);
//        session.setAttribute("pageNo", Integer.parseInt(pageNo));
//        session.setAttribute("totPg", tot);
//        session.setAttribute("userList", list);
//        return "user";
//    }
//    private String getId

}
