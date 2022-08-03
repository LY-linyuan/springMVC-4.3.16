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
public class MyInterceptor2 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("2222222222拦截器 MyInterceptor 的  preHandle");
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler, ModelAndView modelAndView)
            throws Exception {
        System.out.println("22222222222拦截器 MyInterceptor 的  postHandle 方法 ");
        if (modelAndView != null) {
            // 修改数据
            modelAndView.addObject("myDate", new Date());
            // 修改视图
            modelAndView.setViewName("other");
        }
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        System.out.println("222222222MyInterceptor 的  afterCompletion 方法");
    }
}
