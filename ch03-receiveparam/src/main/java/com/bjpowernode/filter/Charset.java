package com.bjpowernode.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author 临渊
 * @Date 2022-08-02 7:55
 */
public class Charset implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
