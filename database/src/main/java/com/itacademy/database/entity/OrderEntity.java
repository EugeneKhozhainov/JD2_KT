package com.itacademy.database.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders", schema = "car_rent_storage")
@Inheritance(strategy = InheritanceType.JOINED)
public class OrderEntity extends BaseEntity<Long> {

    public LocalDate created;

    public LocalDate dateFrom;

    public LocalDate dateTo;

    @Enumerated(EnumType.STRING)
    public OrderStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", nullable = false)
    private UserEntity user;

    @OneToOne(mappedBy = "order")
    private CarEntity car;
}
