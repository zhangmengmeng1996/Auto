package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
测试组的方法,把他分类
 */
public class GroupsOnMethod {
    @Test(groups = "server")
    public void test1(){
        System.out.println("这是服务端组的测试方法11");
    }
    @Test(groups="server")
    public void test2(){
        System.out.println("这是服务端组的测试方法22");
    }
    @Test(groups = "client")
    public void test3(){
        System.out.println("这是客户端的测试方法111");
    }
    @Test(groups = "client")
    public void test4(){
        System.out.println("这是客户端组的测试方法222");
    }
    @BeforeGroups("server")
    public void beforeG(){
        System.out.println("这里是服务端组的之前测试方法");
    }
    @AfterGroups("server")
    public void afterG(){
        System.out.println("这里是服务短租测试之后执行的方法");
    }
}
