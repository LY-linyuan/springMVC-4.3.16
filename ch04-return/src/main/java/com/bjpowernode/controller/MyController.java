package com.bjpowernode.controller;

import com.bjpowernode.vo.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @requestmapping
 *      value : 所有请求地址的公共部分
 *          位置 : 类的上面
 */
@Controller
public class MyController {

    /**
     *  处理器方法返回String 表示逻辑视图名称 需要配置视图解析器
     */
    @RequestMapping(value = {"/returnString-view.do"})
    public String doReturnView(HttpServletRequest request, String name, Integer age) throws UnsupportedEncodingException {
        System.out.println(name + age);
        request.setAttribute("name", name);
        request.setAttribute("age", age);
        // show : 逻辑视图名称 项目中配置了试图解析器
        // 框架对视图执行forward转发操作
        return "show";
    }

    // 处理器方法返回String 表示完整视图路径 此时不能配置试图解析器
    @RequestMapping(value = {"/returnString-view2.do"})
    public String doReturnView2(HttpServletRequest request, String name, Integer age) throws UnsupportedEncodingException {
        System.out.println("222========" + name + age);
        request.setAttribute("name", name);
        request.setAttribute("age", age);
        // 完整视图路径 不能配置视图解析器
        // 框架对视图执行forward转发操作
        return "/WEB-INF/view/show.jsp";
    }

    // 处理器处理ajax json 请求
    // 手工实现 ajax json 请求 代码有重复的 1. java对象转换为json 2. 统统HttpServletResponse输出json数据
    @RequestMapping(value = {"/returnVoid-ajax.do"})
    public void doReturnVoidAjax(HttpServletResponse response, String name, Integer age) throws IOException {
        System.out.println("222========" + name + age);
        // 处理ajax 使用json做数据的格式
        // 认为service调用完成了
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        String json = "";
        // 把这里的对象转化为json合适的数据
        if (student != null) {
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(student);
            System.out.println("输出student 转换的json " + json);
        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(json);
        writer.flush();
        writer.close();

    }
    /**
     * 处理器方法返回一个 Student 通过矿建转化为json响应ajax请求
     *      @ResponseBody
     *              作用 要把这个处理器方法返回对象 转为json后同HttpServletResponse输出给浏览器
     *              位置 方法上  和其他注解没有位置先后关系
     *    返回框架的处理流程 :
     *          1. 框架会把返回的Student类型  调用框架中的ArrayList<HttpMessageConverter>每个类的ConWrite</HttpMessageConverter>
     *              检查哪个是 true
     *          2. 调用write方法 吧Student对象转换为json
     *          3. 框架会调用@ResponseBody这个功能 输出到浏览器响应ajax请求
     *
     */
    @RequestMapping(value = "/returnStudentJson.do")
    @ResponseBody
    public Student doStudentJsonObject(String name, Integer age) {
        Student student = new Student();
        student.setAge(age);
        student.setName(name);
        return student;
    }

    /**
     * 过滤器返回一个List集合
     */
    @RequestMapping(value = "/returnStudentJsonArray.do")
    @ResponseBody
    public List<Student> doStudentJsonObjectArray(String name, Integer age) {
        List<Student> studentList = new ArrayList<>();
        Student student = new Student();
        student.setAge(age);
        student.setName(name);
        studentList.add(student);
        Student student2 = new Student();
        student2.setAge(18);
        student2.setName("王五");
        studentList.add(student2);
        return studentList;
    }
    /**
     *  处理器方法返回值是String , String 表示数据的不是视图
     *      区分返回值字符串是数据还是视图
     *          看有没有@ResonseBody注解
     *              如果有  返回的就是数据
     *               反之就是视图
     *        默认使用“text/plain;charset=ISO-8859-1” 编码 作为contextType导致中文乱码
     *          解决方案 @RequestMapping 增加一个属性 produces 使用这个属性指定新的ContextType
     */
    @RequestMapping(value = "/returnStringData.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String doStringData(String name, Integer age){
        return "Hello SpringMVC 返回对象";
    }

}
