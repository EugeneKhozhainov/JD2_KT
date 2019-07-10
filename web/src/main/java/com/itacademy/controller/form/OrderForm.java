package com.itacademy.controller.form;

import com.itacademy.database.entity.CarEntity;
import com.itacademy.database.entity.OrderStatus;
import com.itacademy.database.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class OrderForm {

    private Long carId;
    private String passport;
    private String dateFrom;
    private String dateTo;

    private Integer pageCount;
    private Integer pageNumber;

}
