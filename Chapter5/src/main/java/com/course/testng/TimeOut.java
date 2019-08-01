package com.course.testng;

import org.testng.annotations.Test;

public class TimeOut {
    @Test(timeOut = 3000)//毫秒
    public void test() throws InterruptedException{
       // Thread.sleep(millis:2000);
    }
}
