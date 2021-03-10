package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.web.mvc.controller.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

/**
 * 用户注册页面
 *
 * @Author hy
 * @Date 2021/3/1 21:21
 */
@Path("/user/listAll")
public class UserController implements RestController {

    @Resource(name = "bean/UserService")
    private UserService userService;


    @Override
    @GET
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        List<User> list = userService.listAll();


        return null;
    }
}
