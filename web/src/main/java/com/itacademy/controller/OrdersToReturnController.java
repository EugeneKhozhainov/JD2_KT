package com.itacademy.controller;

import com.itacademy.controller.form.OrderToReturnForm;
import com.itacademy.database.entity.OrderEntity;
import com.itacademy.database.entity.OrderStatus;
import com.itacademy.exception.ValidatorException;
import com.itacademy.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrdersToReturnController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/ordersToReturn")
    public String doGet(Model model) {
        model.addAttribute("orderList", orderService.getOrdersToReturn());
        return "ordersToReturn";
    }

    @PostMapping(value = "/ordersToReturn")
    public String doPost(Model model, @ModelAttribute("orderToDeliveryForm") OrderToReturnForm orderToReturnForm) {

        if (orderToReturnForm.getOrderId() == null) {
            throw new ValidatorException("Order cannot be null");
        }

        OrderEntity orderEntity = orderService.getById(orderToReturnForm.getOrderId()).get();
        orderEntity.setStatus(OrderStatus.RETURNED);
        orderEntity.setDescription(orderToReturnForm.getDescription());

        orderService.save(orderEntity);

        return "return_success";
    }

}
