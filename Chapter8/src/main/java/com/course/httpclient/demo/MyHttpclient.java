package com.course.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import javax.swing.text.html.parser.Entity;
import javax.xml.ws.Response;
import java.io.IOException;
import java.nio.charset.Charset;

/*
httpclient测试
 */
public class MyHttpclient {
    /*
    test测试解决
   */
    @Test
    public void test() throws IOException {
        //创建httpclient客户端
        // httpClient=HttpClientBuilder.create().build();

        String result;//定义一个变量用来存储，存储单位
        HttpGet httpGet=new HttpGet("http://www.baidu.com");
        //这是用来执行get方法的
        HttpClient httpClient=new DefaultHttpClient();
        //调用执行
       HttpResponse httpResponse= httpClient.execute(httpGet);
       //为什么不行
       result=EntityUtils.toString(httpResponse.getEntity(),"utf-8");
       System.out.println(result);
//改动

    }

}





