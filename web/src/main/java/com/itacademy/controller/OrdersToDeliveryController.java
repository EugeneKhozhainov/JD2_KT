package com.itacademy.controller;

import com.itacademy.controller.form.OrderForm;
import com.itacademy.controller.form.OrderToDeliveryForm;
import com.itacademy.database.entity.OrderEntity;
import com.itacademy.database.entity.OrderStatus;
import com.itacademy.exception.ValidatorException;
import com.itacademy.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrdersToDeliveryController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/ordersToDelivery")
    public String doGet(Model model) {
        model.addAttribute("orderList", orderService.getOrdersToDelivery());
        return "ordersToDelivery";
    }

    @PostMapping(value = "/ordersToDelivery")
    public String doPost(Model model, @ModelAttribute("orderToDeliveryForm") OrderToDeliveryForm orderToDeliveryForm) {

        if (orderToDeliveryForm.getOrderId() == null) {
            throw new ValidatorException("Order cannot be null");
        }

        OrderEntity orderEntity = orderService.getById(orderToDeliveryForm.getOrderId()).get();
        orderEntity.setStatus(OrderStatus.DELIVERED);
        orderEntity.setDescription(orderToDeliveryForm.getDescription());

        orderService.save(orderEntity);

        return "delivery_success";
    }

}
