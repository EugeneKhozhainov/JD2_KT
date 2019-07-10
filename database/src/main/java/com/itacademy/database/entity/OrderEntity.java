package com.itacademy.database.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders", schema = "car_rent_storage")
@Inheritance(strategy = InheritanceType.JOINED)
public class OrderEntity extends BaseEntity<Long> {

    @Version
    private Integer version;

    private String passport;

    private LocalDate created;

    private LocalDate dateFrom;

    private LocalDate dateTo;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Double amount;

    private String description;

    public String getDeliveryDescription() {
        return dateFrom + "-" + dateTo + ", " + getCar().getDescription();
    }

    public String getReturnDescription() {
        return dateFrom + "-" + dateTo + ", " + getCar().getDescription();
    }

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToOne
    @JoinColumn(name = "admin_id")
    private UserEntity admin;

    @OneToOne
    @JoinColumn(name = "car_id")
    private CarEntity car;

}
