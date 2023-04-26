package com.scriptServer.myspringmvc.servlets;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scriptServer.utils.Tools;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/go.up")
public class wechat extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String rootPath = "/www/wwwroot/pics/roles/";

    /*** @see HttpServlet#HttpServlet()*/
    public wechat() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("图片存放");
        request.setCharacterEncoding("UTF-8");
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {
            try {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload fileUpload = new ServletFileUpload(factory);
                List<FileItem> items = fileUpload.parseRequest(request);
                Map<String, String> mp = new HashMap<>();
                for (FileItem item : items) {
                    if (item.isFormField()) {
                        String name = item.getFieldName();
//                        System.out.println(name + " " + URLDecoder.decode(item.getString(), "utf-8"));
                        String val = URLDecoder.decode(item.getString(), StandardCharsets.UTF_8);
                        mp.put(name, val);
                    }
                }
                for (FileItem item : items) {
                    if (item.isFormField()) {
                        continue;
                    }
                    String originFileName = item.getName();
                    String fileName = mp.get("id") + originFileName.substring(originFileName.lastIndexOf('.'));
                    String fileDir = rootPath + mp.get("sid");
                    File dirFile = new File(fileDir);
                    if (!dirFile.exists()) {
                        dirFile.mkdirs();
                    }
                    String fullPath = fileDir + "/" + fileName;
                    System.out.println(fullPath);
                    File saveFile = new File(dirFile, fileName);
                    saveFile.setReadable(true);
                    saveFile.setWritable(true);
                    item.write(saveFile);
                    saveFile.setReadable(true);
                    saveFile.setWritable(true);
//                    Tools.changeFolderPermission(saveFile);
//                    Runtime.getRuntime().exec("chmod 666 " + fullPath);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /*** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}