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
    private long btime;
    /**
     *  preHandle 整个方法的门户  非常重要
     *
     *  preHandle 预处理方法
     *
     *      参数   Object handler 被拦截的控制器对象
     *          返回值boolean
     *              true :
     *                  拦截器 MyInterceptor 的  preHandle
     *                  执行 MyController 的 doSome 方法
     *                   拦截器 MyInterceptor 的  postHandle 方法
     *                   MyInterceptor 的  afterCompletion 方法
     *              false :  请求没有通过拦截器
     *                  拦截器 MyInterceptor 的  preHandle
     *      特点 ：
     *          1. 方法在控制器方法(MyController的doSome) 之前执行的
     *              用户请求首先到达此方法
     *           2. 可以验证用户是都已经登录
     *              如果验证失败可以阻断请求
     *              成功  放行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        btime = System.currentTimeMillis();
        System.out.println("拦截器 MyInterceptor 的  preHandle");
        // 给浏览器一个返回结果
        // request.getRequestDispatcher("/tips.jsp").forward(request, response);
        return true;
    }

    /**
     * postHandle : 后处理方法.
     *  参数 :
     *      Object handler : 宝蓝街的处理器对象
     *
     *      ModelAndView modelAndView  : 处理器方法的返回值
     *
     *    特点 : 1 在处理器方法后执行
     *          2 能获得到ModelAndView 可以修改ModelAndView中的值
     *          3 对原来的执行结果做二次修正
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler, ModelAndView modelAndView)
            throws Exception {
        System.out.println("拦截器 MyInterceptor 的  postHandle 方法 ");
        if (modelAndView != null) {
            // 修改数据
            modelAndView.addObject("myDate", new Date());
            // 修改视图
            modelAndView.setViewName("other");
        }
    }

    /**
     *  最后执行的方法
     *      参数   Object handler   : 被拦截的处理器对象
     *              Exception ex : 被拦截的处理器对象发生的异常
     *         特点 :
     *              1. 在请求处理完成后执行  当你的视图处理完成后, 对视图执行了forward 救人位请求处理完成
     *              2. 一般做资源回收工作, 在冲虚的请求过程中 创建了一些对象, 在这里可以删除 把占用的资源回收
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor 的  afterCompletion 方法");
        long etime = System.currentTimeMillis();
        System.out.println(etime - btime);
    }
}
