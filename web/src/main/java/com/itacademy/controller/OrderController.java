package com.itacademy.controller;

import com.itacademy.controller.form.CarForm;
import com.itacademy.controller.form.OrderForm;
import com.itacademy.database.entity.CarEntity;
import com.itacademy.database.entity.OrderEntity;
import com.itacademy.database.entity.OrderStatus;
import com.itacademy.database.repository.CarRepository;
import com.itacademy.database.repository.OrderRepository;
import com.itacademy.database.repository.UserRepository;
import com.itacademy.exception.ValidatorException;
import com.itacademy.service.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
        model.addAttribute("carList", carService.getFree());
        System.out.println("carList: "+carService.getFree());

        return "user_new_order";
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @PostMapping(value = "/neworder")
    public String doPost(Model model, @ModelAttribute("carForm") CarForm carForm, @ModelAttribute("orderForm") OrderForm orderForm) {
        if (StringUtils.isEmpty(orderForm.getPassport())) {
            throw new ValidatorException("Passport cannot be null");
        }

        if (orderForm.getDateFrom() == null) {
            throw new ValidatorException("Date From cannot be null");
        }

        if (orderForm.getDateTo() == null) {
            throw new ValidatorException("Date To cannot be null");
        }

        if (orderForm.getCarId() == null) {
            throw new ValidatorException("Car cannot be null");
        }

        CarEntity carEntity = carRepository.findById(orderForm.getCarId()).get();

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCreated(LocalDate.now());
        orderEntity.setDateFrom(LocalDate.parse(orderForm.getDateFrom(), formatter));
        orderEntity.setDateTo(LocalDate.parse(orderForm.getDateTo(), formatter));
        orderEntity.setStatus(OrderStatus.BOOKED);
        orderEntity.setCar(carEntity);
        orderEntity.setPassport(orderForm.getPassport());

        long days = ChronoUnit.DAYS.between(orderEntity.getDateFrom(), orderEntity.getDateTo());
        orderEntity.setAmount(days * carEntity.getPrice());

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        orderEntity.setUser(userRepository.findByUsername(user.getUsername()));

        orderRepository.save(orderEntity);
        return "order_success";
    }
}
