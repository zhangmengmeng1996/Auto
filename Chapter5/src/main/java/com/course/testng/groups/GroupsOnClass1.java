package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass1 {
    public void stu1(){
        System.out.println("stu1的运行");
    }
    public void stu2(){
        System.out.println("stu222的运行");
    }
}
