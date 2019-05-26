package com.itacademy.database.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders", schema = "car_rent_storage")
@Inheritance(strategy = InheritanceType.JOINED)
public class OrderEntity extends BaseEntity {

    public String passport;

    public Date created;

    public Date dateFrom;

    public Date dateTo;

    @Enumerated(EnumType.STRING)
    public OrderStatus status;

    public String rejectReason;

    public String damageDescription;

    public Integer carId;
}
