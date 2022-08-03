package com.bjpowernode.controller;

import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 临渊
 * @Date 2022-08-03 11:48
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    // 注册学生
    @RequestMapping(value = "/addStudent.do")
    public ModelAndView addStudent(Student student) {
        ModelAndView modelAndView = new ModelAndView();
        String tips = "注册失败";
        // 调用service处理Student
        int nums = studentService.addStudent(student);
        if (nums > 0) {
            // 注册成功
            tips = "学生[" + student.getName() + "]注册成功";
        }
        // 添加数据
        modelAndView.addObject("tips", tips);
        // 指定结果页面
        modelAndView.setViewName("result");
        return modelAndView;
    }

    // 处理查询 响应ajax
    @RequestMapping("/queryStudent.do")
    @ResponseBody
    public List<Student> queryStudent() {
        // 参数检查 简单的数据处理
        List<Student> studentList = studentService.findStudents();
        return studentList;
    }

}
