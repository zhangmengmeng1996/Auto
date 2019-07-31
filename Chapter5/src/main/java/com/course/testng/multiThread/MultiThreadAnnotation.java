package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThreadAnnotation {
    @Test()
    public void test(){
        System.out.print(1);
        System.out.printf("Thread is : %s%n",Thread.currentThread());
    }
}
