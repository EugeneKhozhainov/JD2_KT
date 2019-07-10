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
@Builder
@Entity
@Table(name = "model_catalog", schema = "car_rent_storage")
@Inheritance(strategy = InheritanceType.JOINED)
public class ModelCatalogEntity extends BaseEntity<Long> {

    public String name;
}
