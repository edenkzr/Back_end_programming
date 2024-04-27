package com.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "excursion")
@Getter
@Setter
public class Excursion {

    private Long id;

    private String excursion_title;

    private BigDecimal excursion_price;

    private String image_URL;

    private Date create_date;

    private Date last_update;

    private Vacation vacation;

    private Set<CartItem> cart_items;

    public Excursion() {}
}
