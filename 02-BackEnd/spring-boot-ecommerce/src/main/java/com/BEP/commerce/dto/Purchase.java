package com.BEP.commerce.dto;

import com.BEP.commerce.entities.Cart;
import com.BEP.commerce.entities.CartItem;
import com.BEP.commerce.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;

}
