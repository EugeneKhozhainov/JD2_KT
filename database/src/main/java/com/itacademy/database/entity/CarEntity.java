package com.itacademy.database.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Data
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "car", schema = "car_rent_storage")
@Inheritance(strategy = InheritanceType.JOINED)
public class CarEntity extends BaseEntity<Long>{

    public String brand;

    public String model;

    public Double price;

    public String status;

    public String getDescription() {
        return brand + " " + model + ", price: " + price;
    }

}
