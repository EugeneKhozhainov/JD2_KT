package com.itacademy.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "company", schema = "car_rent_storage")
@Inheritance(strategy = InheritanceType.JOINED)
public class Company extends BaseEntity<Long> {

    private String name;

    @OneToMany(mappedBy = "company")
    private Set<UserEntity> userEntities = new HashSet<>();
}
