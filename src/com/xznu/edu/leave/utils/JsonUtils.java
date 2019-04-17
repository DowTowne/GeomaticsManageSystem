package com.xznu.edu.leave.utils;

import com.google.gson.Gson;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonUtils {
    public static void toJson(Object data) throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        Gson gson = new Gson();
        String result = gson.toJson(data);
        response.setContentType("text/json; charset=utf-8");
        response.setHeader("Cache-Control", "no-cache"); //取消浏览器缓存
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        out.close();
    }
}
