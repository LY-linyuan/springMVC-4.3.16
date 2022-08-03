package com.bjpowernode.controller;

/**
 * @Author 临渊
 * @Date 2022-08-03 16:05
 */
// 表示当用户的年龄有异常, 抛出AgeException异常
public class AgeException extends MyUserException{
    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }
}
