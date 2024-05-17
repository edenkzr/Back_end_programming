package com.BEP.commerce.services;

import com.BEP.commerce.dao.CartRepository;
import com.BEP.commerce.dao.CustomerRepository;
import com.BEP.commerce.dto.Purchase;
import com.BEP.commerce.entities.Cart;
import com.BEP.commerce.entities.CartItem;
import com.BEP.commerce.entities.StatusType;
import com.BEP.commerce.dto.PurchaseResponse;
import com.BEP.commerce.entities.Customer;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@Getter
@Setter
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        //retrieve cart info from dto
        Cart cart = purchase.getCart();

        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        //set cart to 'ordered'
        cart.setStatus(StatusType.ordered);

        //populate cart with cartItems
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));

        cart.setCartItem(purchase.getCartItems());
        cart.setCustomer(purchase.getCustomer());

        //populate customer with cart
        Customer customer = purchase.getCustomer();
        if (customer == null){
            throw new IllegalStateException("Customer is null");
        }
        customer.add(cart);

        //save to database
        customerRepository.save(customer);
        //cartRepository.save(cart); <-- this was the bug causing the duplicates

        //return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        //generate random UUID number (UUID version-4)
        return UUID.randomUUID().toString();
    }
}
