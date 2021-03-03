package org.geektimes.projects.user.web.controller;

import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * 用户注册页面
 *
 * @Author yang.hu
 * @Date 2021/3/1 21:21
 */
@Path("/goRegister")
public class RegisterPageController implements PageController {

    @Override
    @GET
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return "/WEB-INF/jsp/register.jsp";
    }
}
