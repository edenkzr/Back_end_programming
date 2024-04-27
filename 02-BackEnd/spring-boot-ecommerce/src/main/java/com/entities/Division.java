package com.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "division")
@Getter
@Setter
public class Division {

    private Long id;

    private String division_name;

    private Date create_date;

    private Date last_update;

    private Country country;

    private Long country_id;

    private Set<Customer> customers;

    public Division() {
    }
}
