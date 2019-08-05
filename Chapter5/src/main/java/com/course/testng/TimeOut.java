package com.course.testng;

import org.testng.annotations.Test;

public class TimeOut {
    //超时处理
    @Test(timeOut = 3000)//毫秒
    public void test() throws InterruptedException{
       Thread.sleep(2000);
    }
    @Test(timeOut = 2000)//毫秒
    public void test2() throws InterruptedException{
        Thread.sleep(3000);
    }
}
