package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @program: Auto
 * @description: 带cookies的post请求
 * @author: mengmeng
 * @create: 2019-09-08 17:58
 **/
public class MyCookiesForPost {
    private String url;
    private String url2;
    private ResourceBundle bundle;
    private CookieStore cookieStore;
    @BeforeTest
    public void BeforeTest(){
        bundle=ResourceBundle.getBundle("application");
        String m=bundle.getString("getWithPostCookies.uri");
        String n=bundle.getString("test.url");
        url=n+m;
        String m2=bundle.getString("test.url");
        String n2=bundle.getString("getCookies.uri");
        String o=bundle.getString("getWithCookies.uri");
        url2=m2+n2;
    }
    @Test
    public void test() throws IOException {
        HttpGet get =new HttpGet(url2);//获取请求的url
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
    //post请求模拟
    @Test(dependsOnMethods = {"test"})
    public void Test2() throws IOException {
        //获取client
        HttpClient client=new DefaultHttpClient();
        //定义方法
        HttpPost post=new HttpPost(url);
        System.out.print(url);
        //设置参数
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","huhansan");
        jsonObject.put("age","18");
        //设只请求头

        post.setHeader("content-type","application/json");
        System.out.println(jsonObject.toString());
        StringEntity entity=new StringEntity(jsonObject.toString(),"utf-8");
        post.setEntity(entity);
        //存cookie
        ((DefaultHttpClient) client).setCookieStore(cookieStore);
        //执行
        HttpResponse response=client.execute(post);
        String result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        JSONObject jsonObject1=new JSONObject(result);
        String success= (String) jsonObject1.get("huhansan");
        String status= (String) jsonObject1.get("status");

    }
}
