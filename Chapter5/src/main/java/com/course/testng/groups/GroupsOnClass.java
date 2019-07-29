package com.course.testng.groups;

import org.testng.annotations.Test;
/*
方法中的组测试
 */
@Test(groups = "stu")
public class GroupsOnClass{
    public void stu1(){
        System.out.println("stu1的运行");
    }
    public void stu2(){
        System.out.println("stu222的运行");
    }
}
