package com.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "country")
@Getter
@Setter
public class Country {

    private Long id;

    private String country_name;

    private Date create_date;

    private Date last_update;

    private Set<Division> divisions;

    public Country() {}
}
