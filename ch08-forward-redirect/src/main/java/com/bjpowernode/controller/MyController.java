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
     * 处理器方法返回ModelAndView  实现转发操作  forward
     *  语法 setViewName("forward: 视图文件的完整路径")
     *      forward 特点 : 不合试图解析器一起工作 就当没有视图解析爱
     *
     */
    @RequestMapping(value = {"/doForward.do"}, method = RequestMethod.POST)
    public ModelAndView doSome(String name, Integer age) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", name);
        mv.addObject("fun", age);
        // mv.setViewName("show");
        // 显示转发
        mv.setViewName("forward:/WEB-INF/view/show.jsp");
        return mv;
    }

    /**
     *  处理器方法 返回ModelAndView 实现重定向Redirect
     *  语法 setViewName("redirect: 视图文件的完整路径")
     *       redirect 特点 : 不合试图解析器一起工作 就当没有视图解析爱
     *
     *     2 在目标hell.jsp中可以使用参数集合对象${param.name} ${param.age} 获取请求参数
     */
    @RequestMapping(value = {"/doRedirect.do"}, method = RequestMethod.POST)
    public ModelAndView doOther(String name, Integer age) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", name  + "0123552");
        mv.addObject("age", age);
        // mv.setViewName("show");
        // 显示转发
        mv.setViewName("redirect:/hello.jsp");
        return mv;
    }
}
