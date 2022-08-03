package com.bjpowernode.handle;

import com.bjpowernode.controller.AgeException;
import com.bjpowernode.controller.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author 临渊
 * @Date 2022-08-03 16:10
 */

/**
 *  @ControllerAdvice : 控制器增强  给控制器增加异常处理功能
 *      位置 类上面
 *     特点 : 必须让框架知道这个注解所在的包名, 需要在springmvc配置文件声明组件扫描器
 *      指定 @ControllerAdvice 所在的包名
 */
@ControllerAdvice
public class GlobalException {
    /**
     *  处理异常额方法和控制器中的方法一样
     *      形参 Exception 表示Controller抛出的异常类
     *          通过形参可以获取发生的异常信息
     * @ExceptionHandler(异常的class) : 表示异常的类型当发生此类异常时,
     *          由当前方法处理
     */

    @ExceptionHandler(value = NameException.class)
    public ModelAndView doNameException(Exception exception) {
        /**
         *    1  记录到日志文件 时间方法 异常内容
         *      2 发送通知  给相关人员
         *      3 给用户友好提示
         */
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "姓名必须是张三");
        mv.addObject("ex", exception);
        mv.setViewName("nameError");
        return mv;
    }

    @ExceptionHandler(value = AgeException.class)
    public ModelAndView doAgeException(Exception exception) {
        /**
         *    1  记录到日志文件 时间方法 异常内容
         *      2 发送通知  给相关人员
         *      3 给用户友好提示
         */
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "age不能大于80");
        mv.addObject("ex", exception);
        mv.setViewName("ageError");
        return mv;
    }

    // 处理其他异常  不知名的异常
    @ExceptionHandler()
    public ModelAndView doOtherException(Exception exception) {
        /**
         *    1  记录到日志文件 时间方法 异常内容
         *      2 发送通知  给相关人员
         *      3 给用户友好提示
         */
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "未知名异常");
        mv.addObject("ex", exception);
        mv.setViewName("defaultError");
        return mv;
    }
}
