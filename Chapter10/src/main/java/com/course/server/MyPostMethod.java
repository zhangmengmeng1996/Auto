package com.course.server;

import com.course.bean.User;
import com.sun.deploy.net.HttpResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: Auto->MyPostMethod
 * @description: post请求
 * @author: zhangmm3
 * @create: 2019-11-19 18:13
 **/
@RestController
@Api(value = "/",description = "这是我的全部post请求")
@RequestMapping("/v1")
public class MyPostMethod {
    private static Cookie cookie;

    /**
     *带cookies信息的post请求
     * @param response
     * @param userName
     * @param passWord
     * @return
     */
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(HttpServletResponse response, @RequestParam(value = "userName",required = true) String userName,@RequestParam(value = "passWord",required = true) String passWord){
        if (userName.equals("zhangsan")&&passWord.equals("1234")){
            cookie=new Cookie("login","true");
            response.addCookie(cookie);
            return "恭喜你登录成功";
        }
        return "用户名或密码错误";
    }

    /**
     * 获取用户列表
     * @param request
     * @param user
     * @return
     */
    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "post")
    public String getUserList(HttpServletRequest request, @RequestBody User user) {
        User user1;
        Cookie[] cookies=request.getCookies();
        for(Cookie c:cookies){
            if (c.getName().equals("login")&&c.getValue().equals("true")
                    &&user.getUserName().equals("zhangsan")&&user.getPassword().equals("123456")){
                    user = new User();
                    user.setName("lisi");
                    user.setAge("18");
                    user.setSex("man");
                    return  user.toString();
            }
        }
        return "参数不合法";
    }


}
