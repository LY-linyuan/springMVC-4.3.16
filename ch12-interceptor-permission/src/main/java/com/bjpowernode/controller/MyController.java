package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * @requestmapping
 *      value : 所有请求地址的公共部分
 *          位置 : 类的上面
 */
@Controller
public class MyController {

    @RequestMapping(value = {"/user/some.do"}, method = RequestMethod.POST)
    public ModelAndView doSome(String name, Integer age){
        System.out.println("执行 MyController 的 doSome 方法");
        ModelAndView mv = new ModelAndView();
        // 根据请求参数抛出异常
        mv.addObject("name", name);
        mv.addObject("age", age);
        // mv.setViewName("show");
        // 显示转发
        mv.setViewName("forward:/WEB-INF/view/show.jsp");
        return mv;
    }
}
