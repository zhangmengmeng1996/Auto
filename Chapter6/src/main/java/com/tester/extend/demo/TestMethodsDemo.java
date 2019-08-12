package com.tester.extend.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/*
加断言的测试方法
 */
public class TestMethodsDemo {
    @Test
    public void test1(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test2(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test3(){
        Assert.assertEquals("aaa","aaa");
    }
    /*
    断言
     */
    @Test
    public void logDemo(){
        Reporter.log("这是我自己的日志");
        //throw new RuntimeException("这是运行时的异常");
    }
}
