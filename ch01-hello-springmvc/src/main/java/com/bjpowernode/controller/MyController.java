package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author 临渊
 * @Date 2022-08-01 16:12
 */

/**
 * @Controller : 创建处理器对象, 对象放在springmvc容器在
 *  位置 : 在类的上面
 *
 *      能处理请求的都是控制器(处理器) : MyController能处理请求
 *                       叫做后端控制器(back controller)
 */
@Controller
public class MyController {
    /**
     *  处理用户提交的请求  在springmvc中是使用方法来处理的
     *      方法是自定义的  可以有多种返回值 多种参数  方法名称自定义
     */

    /**
     *  准备使用doSome 方法处理some.do 请求
     * @RequestMapping 请求映射 作用把一个请求和一个方法绑定在一起
     *      属性
     *          1. value 是一个String 表示请求的uri地址(some.do)
     *              value值必须是唯一的 不能重复  使用时推荐以“/” 开头
     *      位置
     *          1. 在方法的上面
     *          2.在类的上面
     *
     *     说明 使用RequestMapping修饰的方法叫做处理器方法或者控制器方法
     *     使用@RequestMapping 修饰的方法可以处理请求的 类似servlet中的doGet  doPost
     *
     *     返回值 ModelAndView :
     *              Modal : 数据  请求处理完成后  要显示给用户的数据
     *              view : 试图, 比如jsp等等。
     */
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome() {  // doget() service请求
        // 处理some.do的请求的
        ModelAndView mv = new ModelAndView();
        // 添加数据  框架会在请求的最后把数据方法哦request作用域中
        // request.setAttribute("msg", "欢迎使用springmvc做web开发");
        mv.addObject("msg", "欢迎使用springmvc做web开发");
        mv.addObject("fun", "执行dosome方法");

        // 指定视图 指定视图的完整路径
        // 框架对试图的使用  执行的是forward 转发操作request.getRequestDispather("/show.jsp").forward(...)
        mv.setViewName("/show.jsp");

        // 返回mv
        return mv;
    }
}
