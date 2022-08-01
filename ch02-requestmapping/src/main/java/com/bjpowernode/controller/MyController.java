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
@RequestMapping("/test")
public class MyController {

    /**
     * @Requestmapping : 请求映射
     *      属性 : method , 表示请求的方式  他的值是RequestMethod的枚举值
     *          一如表示get请求方式 RequestMethod.GET
     *          post 方式 RequestMethod.POST
     */
    // 指定some.do 使用get请求方式
    @RequestMapping(value = {"/some.do"}, method = RequestMethod.GET)
    public ModelAndView doSome() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用springmvc做web开发");
        mv.addObject("fun", "执行dosome方法");
        mv.setViewName("show");

        return mv;
    }

    // 指定other.do是post请求方式
    @RequestMapping(value = {"/other.do", "/second.do"}, method = RequestMethod.POST)
    public ModelAndView doOther() {  // doget() service请求
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用springmvc做web开发");
        mv.addObject("fun", "执行doOther方法");
        mv.setViewName("other");

        return mv;
    }

    // 不指定任何请求方式
    @RequestMapping(value = {"first.do"})
    public ModelAndView doFirst(HttpServletRequest request, HttpServletResponse response,
                                HttpSession session) throws UnsupportedEncodingException {  // doget() service请求
        request.setCharacterEncoding("UTF-8");
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用springmvc做web开发" + request.getParameter("name"));
        mv.addObject("fun", "执行doFirst方法");
        mv.setViewName("other");

        return mv;
    }
}
