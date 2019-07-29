package com.course.testng;

import org.testng.annotations.*;

/*
基本注解的使用方法，每一个测试方法之前之后都会运行
 */
public class BasicAnnotation {
    /*
    基本注解的测试用例1
     */
    @Test
    public void testCase1(){
        System.out.println("这是测试方法1");
    }
    @Test
    public void testCase2(){
        System.out.println("这是测试方法2");
    }
    /*
    方法之前运行这个标签
     */
    @BeforeMethod
    public  void beforeM(){
        System.out.println("这是测试方法之前运行");
    }
    /*
    这是测试方法之后运行
     */
    @AfterMethod
    public void afterM(){
        System.out.println("这是测试方法之后运行");
    }

    @BeforeClass
    public void boforeC(){
        System.out.println("这是类之前运行");
    }

    @AfterClass
    public void afteeC(){
        System.out.println("这是类之后运行的测试");
    }

    @BeforeSuite
    public void  beforeS(){
        System.out.println("这是类之前的测试套件");
    }

    @AfterSuite
    public void afterS(){
        System.out.println("这是类之后运行的测试套件");
    }

}
