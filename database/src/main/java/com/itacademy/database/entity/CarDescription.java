package com.itacademy.database.entity;

import lombok.*;

import javax.persistence.*;

@Data
@ToString(exclude = "carEntity")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "car_description", schema = "car_rent_storage")
@Inheritance(strategy = InheritanceType.JOINED)
public class CarDescription extends BaseEntity {

    public String description;

    @OneToOne(cascade = CascadeType.ALL)
    public CarEntity carEntity;
}
