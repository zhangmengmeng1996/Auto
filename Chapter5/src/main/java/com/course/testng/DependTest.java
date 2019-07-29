package com.course.testng;

import org.testng.annotations.Test;

/*
依赖测试
 */
public class DependTest {
    @Test
    public void test(){
        System.out.println("这是测试1");
    }
    /*
    当被依赖的测试的方法执行失败了，依赖的会被忽略
     */
    @Test(dependsOnMethods ={"test"} )
    public void test2(){
        System.out.println("这是测试2");
    }
}
