package com.itacademy.web.servlet;

import com.itacademy.database.dao.CarDao;
import com.itacademy.database.entity.CarEntity;
import com.itacademy.service.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/car")
public class UserServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageCount = 5;
        if (request.getParameter("pageCount") != null) {
            pageCount = Integer.parseInt(request.getParameter("pageCount"));
        }

        int pageNumber = 1;
        if (request.getParameter("pageNumber") != null) {
            pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        }

        List<CarEntity> carList = CarDao.getInstance().getEntriesWithFilter("BMW", "X6", 600.0, pageNumber, pageCount);
        System.out.println("List size is = " + carList.size());
        carList.stream().forEach(System.out::println);
        getServletContext().setAttribute("carList", carList);

        System.out.println(String.format("pageCount=%s, pageNumber=%s", pageCount, pageNumber));

        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/car.jsp")
                .forward(request, response);
    }

}
