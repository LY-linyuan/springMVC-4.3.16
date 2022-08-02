package com.bjpowernode.vo;

/**
 * @Author 临渊
 * @Date 2022-08-02 9:36
 */

/**
 * 保存请求参数值的普通类
 */
public class Student {
    private String name;
    private Integer age;

    public Student() {
        System.out.println("student无参数构造方法执行了");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("在加入name " + name);
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("在加入age " + age);
        this.age = age;
    }
}
