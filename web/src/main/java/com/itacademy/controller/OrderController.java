package com.itacademy.controller;

import com.itacademy.controller.form.CarForm;
import com.itacademy.controller.form.OrderForm;
import com.itacademy.database.dao.OrderDao;
import com.itacademy.database.entity.CarEntity;
import com.itacademy.database.entity.OrderEntity;
import com.itacademy.database.entity.OrderStatus;
import com.itacademy.database.repository.CarRepository;
import com.itacademy.database.repository.OrderRepository;
import com.itacademy.database.repository.UserRepository;
import com.itacademy.service.service.CarService;
import com.itacademy.service.service.OrderService;
import com.itacademy.service.service.UserService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class OrderController {

    @Autowired
    private CarService carService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/neworder")
    public String getReview(Model model) {
        model.addAttribute("carList", carService.getAll(1, 5));
        return "user_new_order";
    }

    @PostMapping(value = "/neworder")
    public String doPost(Model model, @ModelAttribute("carForm") CarForm carForm, @ModelAttribute("orderForm") OrderForm orderForm) {
        model.addAttribute("carList", carService.getAll(carForm.getPageNumber(), carForm.getPageCount()));

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCreated(LocalDate.now());
        orderEntity.setDateFrom(orderForm.getDateFrom());
        orderEntity.setDateTo(orderForm.getDateTo());
        orderEntity.setStatus(OrderStatus.PENDING);
        //Не очень понял как получить машину по айди, пробовал через репо и через дао
        orderEntity.setCar(carRepository.findByBrand("Ford"));
        //аналогично, как я понимаю нужно будет сюда брать залогиненного юзера
        orderEntity.setUser(userRepository.findByUsername("12"));

        orderRepository.save(orderEntity);
        return "order_success";
    }
}
