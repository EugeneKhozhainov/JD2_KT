package com.itacademy.database.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
@ToString(exclude = "company")
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    public Company company;

    @Enumerated(EnumType.STRING)
    public Role role;
}

