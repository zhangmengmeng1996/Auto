package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @program: Auto
 * @description: 第一个cookies的get方法
 * @author: mengmeng
 * @create: 2019-09-08 15:27
 **/
public class MycookiesForGet {
    private String result;
    private  String result2;
    private ResourceBundle bundle;
    private CookieStore cookieStore;
    /*
    在方法之前执行
     */
    @BeforeTest
    public void beforeTest(){
        //获取配置文件的信息
        bundle=ResourceBundle.getBundle("application",Locale.CHINA);
        //拼接uri
        String m=bundle.getString("test.url");
        String n=bundle.getString("getCookies.uri");
        String o=bundle.getString("getWithCookies.uri");
        result=m+n;
        result2=m+o;
        System.out.println(result);
    }
    /*
    执行get请求
     */
    @Test
    public void test() throws IOException {
        HttpGet get =new HttpGet(result);//获取请求的url
        HttpClient client=new DefaultHttpClient();//获取httpclient
        HttpResponse response=client.execute(get);//执行
        String re=EntityUtils.toString(response.getEntity(),"utf-8");//转换
        System.out.print(re);
        //获取cookies信息
        cookieStore=((DefaultHttpClient) client).getCookieStore();
        List<Cookie> list=cookieStore.getCookies();
        for(Cookie cookie:list){
            String name=cookie.getName();
            String value=cookie.getValue();
            System.out.println(name+":"+value);
        }
    }
    @Test(dependsOnMethods = {"test"})
    public void GetWithCookie() throws IOException {
        HttpGet get=new HttpGet(result2);
        HttpClient client=new DefaultHttpClient();

        ((DefaultHttpClient) client).setCookieStore(cookieStore);

        HttpResponse response=client.execute(get);
        int status=response.getStatusLine().getStatusCode();
        if (status==200){
            String result=EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }


    }
}
