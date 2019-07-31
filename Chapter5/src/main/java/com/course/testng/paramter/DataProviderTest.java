package com.course.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.nio.channels.NonWritableChannelException;

/*
数据参数化测试
 */
public class DataProviderTest {
    @Test(dataProvider = "data")
    public void testProviderDriver(String name,int age){
        System.out.println("name:"+name+"age:"+age);

    }
    /*
  数据参数化的注解需要从这里的数据传到上面的方法中去
     */
    @DataProvider(name="data")
    public Object[][] m(){
        Object[][] o=new Object[][]{
                {"zhangsan",1},
                {"lisi",2}
        };
        return o;
    }
    /*
    根据方法来进行测试传递
     */
    @Test(dataProvider = "methoddata")
    public void test1(String name,int age){
        System.out.println("test1name:"+name+"age:"+age);

    }
    @Test(dataProvider = "methoddata")
    public void test2(String name,int age){
        System.out.println("test2name:"+name+"age:"+age);

    }
    @DataProvider(name="methoddata")
    /*
    可以传递方法
     */
    public Object[][] methodDateTest(Method method){
        Object[][] o=null;
        if(method.getName().equals("test1")){
            o=new Object[][]{
                    {"1111",49},
                    {"2222",50}
            };
        }
        else if (method.getName().equals("test2")){
            o=new Object[][]{
                    {"2222",90},
                    {"30333",60}
            };
        }

        return o;
    }
}
