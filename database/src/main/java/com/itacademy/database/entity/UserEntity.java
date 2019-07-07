package com.itacademy.database.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users", schema = "car_rent_storage")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserEntity extends BaseEntity<Long>{

    public String name;

    public String username;

    public String password;

    @Enumerated(EnumType.STRING)
    public Role role;

    @OneToMany(mappedBy = "user")
    Set<OrderEntity> list = new HashSet<>();
}

