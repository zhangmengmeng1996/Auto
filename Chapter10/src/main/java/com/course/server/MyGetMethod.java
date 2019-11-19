package com.course.server;

import com.sun.javafx.collections.MapListenerHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: Auto->MyGetMethod
 * @description: get请求方法实例即控制层请求映射到对应的方法中
 * @author: zhangmm3
 * @create: 2019-11-14 15:48
 * swagger通过注解表明该接口会生成文档，包括接口名、请求方法、参数、返回信息的等等。
 *
 * @Api：修饰整个类，描述Controller的作用
 * @ApiOperation：描述一个类的一个方法，或者说一个接口
 * @ApiParam：单个参数描述
 * @ApiModel：用对象来接收参数
 * @ApiProperty：用对象接收参数时，描述对象的一个字段
 * @ApiResponse：HTTP响应其中1个描述
 * @ApiResponses：HTTP响应整体描述
 * @ApiIgnore：使用该注解忽略这个API
 * @ApiError ：发生错误返回的信息
 * @ApiImplicitParam：一个请求参数
 * @ApiImplicitParams：多个请求参数
 **/
@RestController
@Api(value = "/",description = "这是我全部的get方法")
public class MyGetMethod {
    /**
     * cookie的get请求
     * @param response
     * @return
     */
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到Cookies",httpMethod = "GET")
    public String getCookies(HttpServletResponse response){
      //创建cookie并将cookie返回到对应的请求中
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜你cookies信息获取成功";

    }

    /**
     * 请求需要携带cookies
     * @param request
     * @return
     */
    @RequestMapping(value = "/getWithCookies",method = RequestMethod.GET)
    @ApiOperation(value = "输入对应的cookies请求",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        if(cookies==null){
            return "这需要输入对应的cookies";
        }
        else
        {
            for(Cookie cookie:cookies){
                if (cookie.getName().equals("login")&&cookie.getValue().equals("true")){
                    return "这是一个需要携带cookies信息才能访问的get请求!";
                }
            }
        }
        return "这是一个需要携带cookies信息才能访问的get请求!";
    }

    /**
     *带参数的get请求
     * Requestparam请求
     * @param start
     * @param end
     * @return map
     */
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value = "带参数的get请求",httpMethod = "GET")
    public Map<String, Integer> getWithParam(@RequestParam Integer start,@RequestParam Integer end){
        Map<String,Integer> map=new HashMap<>();
        map.put("面包",1);
        map.put("牛奶",20);
        return map;
    }

    /**
     * 带参数的get请求
     * PathVariable
     * 按路径请求参数
     * @param start
     * @param end
     * @return
     */
    @RequestMapping(value = "/get/with/param/new/{start}/{end}",method = RequestMethod.GET)
    @ApiOperation(value = "带参数的get请求请求方式不同",httpMethod = "GET")

    public Map<String,Integer> getWithParam1(@PathVariable Integer start,@PathVariable Integer end){
        Map<String,Integer> map=new HashMap<>();
        map.put("花生",1);
        map.put("牛奶",2);
        return map;

    }

}
