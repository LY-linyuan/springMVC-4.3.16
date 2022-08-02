package com.bjpowernode.controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * @requestmapping
 *      value : 所有请求地址的公共部分
 *          位置 : 类的上面
 */
@Controller
public class MyController {
    /**
     *  实现 逐个请求参数:
     *      要求: 处理器方法的星灿明和请求中的参数名必须一致,
     *              同名的请求参数赋值给同名的形参
     *   框架接收请求参数 :
     *      1. 使用request对象接收请求参数
     *       String strName = request.getParameter("name");
     *       String strAge = request.getParameter("age");
     *      2. springmvc框架通过DispatcherServlet调用MyController的doSome方法
     *          调用方法时 , 按名称对应 把接收的参数传给形参
     *          doSome(strName, Integer.ValueOf(strAge))
     *          框架会提供类型转换的功能, 能把string转为 int long float double等简单类型
     *
     *     400 状态码是客户端错误 : 表示请求参数过程中 发生了问题
     */
    @RequestMapping(value = {"/receiveparam/first.do"})
    public ModelAndView doFirst(String name, Integer age) throws UnsupportedEncodingException {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", name);
        mv.addObject("age", age);
        // other 是视图文件的逻辑名称(文件名称)
        mv.setViewName("other");

        return mv;
    }
}
