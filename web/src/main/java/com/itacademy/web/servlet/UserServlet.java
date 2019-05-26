package com.itacademy.web.servlet;

import com.itacademy.service.service.UserService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = userService.getDefaultUser().getUsername();
        String password = userService.getDefaultUser().getPassword();
        String role = String.valueOf(userService.getDefaultUser().getRole());
        String name = userService.getDefaultUser().getName();

        List<String> list = new ArrayList<>();
        list.add(username);
        list.add(password);
        list.add(role);
        list.add(name);

        getServletContext().setAttribute("name", name);
        getServletContext().setAttribute("username", username);
        getServletContext().setAttribute("role", role);
        getServletContext().setAttribute("password", password);


        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/user.jsp")
                .forward(req, resp);
    }
}
