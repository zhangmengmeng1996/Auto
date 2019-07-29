package com.course.testng;

import org.testng.annotations.Test;
/*
忽略测试的方法
 */
public class IgnoreTest {
    @Test
    public void ignore(){
        System.out.println("ignore1执行！" );
    }
    /*
    忽略测试
     */
    @Test(enabled = true)
    public void ignore2(){
        System.out.println("ignore2执行！" );
    }
    @Test(enabled = false)
    public void ignore3(){
        System.out.println("ignore3执行！" );
    }
}
