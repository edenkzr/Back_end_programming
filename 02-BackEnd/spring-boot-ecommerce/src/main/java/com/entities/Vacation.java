package com.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "vacation")
@Getter
@Setter
public class Vacation {

    private Long id;

    private String vacation_title;

    private String description;

    private BigDecimal travel_price;

    private String image_URL;

    private Date create_date;

    private Date last_update;

    private Set<Excursion> excursions;

    public Vacation() {}
}
