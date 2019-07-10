package com.itacademy.controller.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderToDeliveryForm {

    private Long orderId;
    private String description;

}
