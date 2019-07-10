package com.itacademy.controller.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderToReturnForm {

    private Long orderId;
    private String description;

}
