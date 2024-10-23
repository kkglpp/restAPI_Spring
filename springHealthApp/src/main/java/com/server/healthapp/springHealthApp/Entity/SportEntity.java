package com.server.healthapp.springHealthApp.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="sport")
public class SportEntity {
    @Id
    private Integer id;

    private String name;

    private String metric_01;

    private String metric_02;


}
