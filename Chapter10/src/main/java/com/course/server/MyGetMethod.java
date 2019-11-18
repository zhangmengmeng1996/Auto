package com.course.server;

import com.sun.javafx.collections.MapListenerHelper;
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
 **/
@RestController
public class MyGetMethod {
    /**
     * cookie的get请求
     * @param response
     * @return
     */
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
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
    @RequestMapping(value = "/get/with/param/new",method = RequestMethod.GET)
    public Map<String,Integer> getWithParam1(@PathVariable Integer start,@PathVariable Integer end){
        Map<String,Integer> map=new HashMap<>();
        map.put("花生",1);
        map.put("牛奶",2);
        return map;

    }

}
