package com.scriptServer.myspringmvc.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

import static com.scriptServer.utils.Tools.isEmpty;

@WebFilter("*.do")
public class CharacterEncodingFilter implements Filter {
    private String encodingCharacterSet = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) {
        String encoding = filterConfig.getInitParameter("encoding");
        if (isEmpty(encoding)) {
            encoding = "UTF-8";
        }
        encodingCharacterSet = encoding;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        //设置响应头允许ajax跨域访问
        request.setCharacterEncoding(encodingCharacterSet);
        //放行
        chain.doFilter(request, response);
    }
}
