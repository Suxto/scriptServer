package com.scriptServer.script.service.impl;

import com.scriptServer.script.bean.Script;
import com.scriptServer.script.service.ScriptService;
import com.scriptServer.utils.JDBC;
import com.scriptServer.utils.Tools;

import java.util.List;

public class ScriptServiceImpl implements ScriptService {


    @Override
    public List<Script> getScripts(String title, String author) {
        List<Script> scripts;
        if (Tools.isnEmpty(title) && Tools.isnEmpty(author)) {
            String sql = "SELECT * FROM scripts WHERE title RLIKE ? AND author = ?";
            scripts = JDBC.getForList(Script.class, sql, title, author);
        } else if (Tools.isnEmpty(author)) {
            String sql = "SELECT * FROM scripts WHERE author = ?";
            scripts = JDBC.getForList(Script.class, sql, author);
        } else if (Tools.isnEmpty(title)) {
            String sql = "SELECT * FROM scripts WHERE title RLIKE ?";
            scripts = JDBC.getForList(Script.class, sql, title);
        } else {
            String sql = "SELECT * FROM scripts";
            scripts = JDBC.getForList(Script.class, sql);
        }
        return scripts;
    }

//    public static void main(String[] args) {
//        ScriptService scriptService = new ScriptServiceImpl();
//        List<Script> list = scriptService.getScripts(null, "okSpD5JBx8QC1KNP6KUkE5OBYayA");
//        list.forEach(System.out::println);
//    }
}
