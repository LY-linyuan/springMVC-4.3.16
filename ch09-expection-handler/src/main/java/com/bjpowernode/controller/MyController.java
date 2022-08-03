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

    @RequestMapping(value = {"/some.do"}, method = RequestMethod.POST)
    public ModelAndView doSome(String name, Integer age) throws MyUserException{
        ModelAndView mv = new ModelAndView();
        // 根据请求参数抛出异常
        if (!"张三".equals(name)) {
            throw new NameException("姓名不正确");
        }

        if (age == null || age > 80) {
            throw new AgeException("年龄不符合要求");
        }


        mv.addObject("name", name);
        mv.addObject("age", age);
        // mv.setViewName("show");
        // 显示转发
        mv.setViewName("forward:/WEB-INF/view/show.jsp");
        return mv;
    }
}
