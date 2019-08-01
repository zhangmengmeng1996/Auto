package com.course.testng.multiThread;

import org.testng.annotations.Test;
/*
多线程基于xml的测试方法
 */
public class MultiThreadXml {
    @Test
    public void test1(){
        System.out.println(1);
        System.out.printf("Thread is : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test2(){
        System.out.println(2);
        System.out.printf("Thread is : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test3(){
        System.out.println(3);
        System.out.printf("Thread is : %s%n",Thread.currentThread().getId());
    }

}
