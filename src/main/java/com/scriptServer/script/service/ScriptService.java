package com.scriptServer.script.service;

import com.scriptServer.script.bean.Script;

import java.util.List;

public interface ScriptService {
    //    List<Script> getUserList(String keyword, String pageNo);
//    void addUser(String uName, String uAge, String uTel);
//    Script getUserById(String id);
//    void removeUser(Script script);
//    int getPageCount(String keyword);
//    void updateUser(Script script, String uName, String uAge, String uTel);
    List<Script> getScripts(String name, String author);
}
