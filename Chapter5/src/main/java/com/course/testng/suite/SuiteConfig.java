package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/*
测试套件执行的使用方法
 */
public class SuiteConfig {
    /*
    这是测试之前执行的测试套件
     */
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("这是测试之前执行的测试套件");
    }
    /*
    这是测试之后执行的测试套件
     */
    @AfterSuite
    public void afterSuit(){
        System.out.println("这是测试之后执行的测试套件");
    }

    @BeforeTest
    public void beforeT(){
        System.out.println("测试之前执行的方法");
    }
    @AfterTest
    public void  afterT(){
        System.out.println("测试之后的执行方法");
    }
}
