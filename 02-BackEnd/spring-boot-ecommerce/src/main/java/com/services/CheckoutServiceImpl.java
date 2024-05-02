package com.services;

import com.dao.CartRepository;
import com.dao.CustomerRepository;
import com.dto.Purchase;
import com.dto.PurchaseResponse;
import com.entities.Cart;
import com.entities.CartItem;
import com.entities.Customer;
import com.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        //retrieve cart info from dto
        Cart cart = purchase.getCart();

        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        //populate cart with cartItems
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));

        //populate customer with cart
        Customer customer = purchase.getCustomer();
        customer.add(cart);

        //set cart to 'ordered'
        cart.setStatus(StatusType.ordered);

        //save to database
        customerRepository.save(customer);
        cartRepository.save(cart);

        //return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        //generate random UUID number (UUID version-4)
        return UUID.randomUUID().toString();
    }
}
