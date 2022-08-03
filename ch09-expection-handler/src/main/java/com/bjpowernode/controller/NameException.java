package com.bjpowernode.controller;

/**
 * @Author 临渊
 * @Date 2022-08-03 16:04
 */

// 表示当用户的姓名有异常, 抛出NameException异常
public class NameException extends MyUserException{
    public NameException() {
        super();
    }

    public NameException(String message) {
        super(message);
    }
}
