package com.course.testng.groups;

import org.testng.annotations.Test;
/*
测试组的类型的数据有哪些
 */
@Test(groups = "teacher")
public class GroupsOnClass2 {
    public void tes1(){
        System.out.println("tea1的运行");
    }
    public void tea2(){
        System.out.println("tea222的运行");
    }
}
