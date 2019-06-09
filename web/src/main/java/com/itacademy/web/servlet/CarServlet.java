package com.itacademy.web.servlet;

import com.itacademy.config.ServiceConfig;
import com.itacademy.config.WebConfig;
import com.itacademy.database.dao.CarDao;
import com.itacademy.database.entity.CarEntity;
import com.itacademy.service.service.CarService;
import com.itacademy.service.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
@WebServlet("/car")
public class CarServlet extends HttpServlet {
    private static final int DEFAULT_PAGE_NUMBER = 1;
    private static final int DEFAULT_PAGE_SIZE = 5;
    private static final String DEFAULT_BRAND = "BMW";
    private static final String DEFAULT_MODEL = "X6";
    private static final Double DEFAULT_PRICE = 600.0;

    private final UserService userService = UserService.getInstance();

    private ApplicationContext springContext = null;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getData(DEFAULT_BRAND, DEFAULT_MODEL, DEFAULT_PRICE, DEFAULT_PAGE_NUMBER, DEFAULT_PAGE_SIZE);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/car.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageCount = Integer.parseInt(request.getParameter("pageCount"));
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));

        getData(DEFAULT_BRAND, DEFAULT_MODEL, DEFAULT_PRICE, pageNumber, pageCount);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/car.jsp")
                .forward(request, response);
    }

    private void getData(String brand, String model, Double price, Integer pageNumber, Integer pageCount) {
        ApplicationContext context = getSpringContext();
        CarService carService = context.getBean(CarService.class);
        List<CarEntity> carList = carService.getFiltered(brand, model, price, pageNumber, pageCount);
        System.out.println("List size is = " + carList.size());
        carList.stream().forEach(System.out::println);
        getServletContext().setAttribute("carList", carList);

        System.out.println(String.format("pageCount=%s, pageNumber=%s", pageCount, pageNumber));
    }

    private ApplicationContext getSpringContext() {
        if (springContext == null) {
            springContext = new AnnotationConfigApplicationContext(WebConfig.class);
        }
        return springContext;
    }

}
