package com.bjpowernode.handle;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @Author 临渊
 * @Date 2022-08-03 17:14
 */

/**
 *  拦截器类拦截用户的请求
 */

public class MyInterceptor implements HandlerInterceptor {
    // 验证登录的用户信息 正确 return true 其他 false
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("11111111拦截器 MyInterceptor 的  preHandle");
        String loginName = "";
        // 从session获取name的值
        Object name = request.getSession().getAttribute("name");
        if (name != null) {
            loginName = (String) name;
        }
        // 判断是不是张三
        if (!"zs".equals(loginName)) {
            // 给用户一个提示
            request.getRequestDispatcher("/tips.jsp").forward(request, response);
            return false;
        }
        // zs
        return true;
    }
}
