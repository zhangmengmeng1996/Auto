package com.course.testng;

import org.testng.annotations.Test;

/*
我们期望程序程序在进行某些不合法的参数时抛出异常
 */
public class ExceptedException {
    @Test(expectedExceptions = RuntimeException.class)
    public void run(){
        System.out.println("这是一个失败的异常测试");
    }
    @Test(expectedExceptions = RuntimeException.class)
    public void run2(){
        System.out.println("这是一个成功的异常测试");
        throw new  RuntimeException();
    }
}
