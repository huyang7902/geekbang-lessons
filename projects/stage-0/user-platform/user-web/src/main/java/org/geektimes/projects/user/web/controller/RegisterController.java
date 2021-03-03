package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.sql.DBConnectionManager;
import org.geektimes.web.mvc.controller.RestController;

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
@Path("/register")
public class RegisterController implements RestController {

    private DatabaseUserRepository userRepository = new DatabaseUserRepository(DBConnectionManager.instance);

    @Override
    @GET
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        String inputName = request.getParameter("inputName");
        String inputEmail = request.getParameter("inputEmail");
        String inputPhoneNumber = request.getParameter("inputPhoneNumber");
        String inputPassword = request.getParameter("inputPassword");

        User user = new User();
//        user.setId(0L);
        user.setName(inputName);
        user.setPassword(inputPassword);
        user.setEmail(inputEmail);
        user.setPhoneNumber(inputPhoneNumber);

        userRepository.save(user);

        return "注册成功！";
    }
}
