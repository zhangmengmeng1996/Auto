package com.course.testng.multiThread;

import org.testng.annotations.Test;
/*
多线程测试基于注解的方法
 */
public class MultiThreadAnnotation {
    //10个线程的测试,线程池默认1个
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test(){
        System.out.println(1);
        System.out.printf("Thread is : %s%n",Thread.currentThread().getId());
    }
}
