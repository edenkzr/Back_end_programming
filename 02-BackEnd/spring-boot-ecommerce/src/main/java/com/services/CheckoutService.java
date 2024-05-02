package com.services;

import com.config.dto.Purchase;
import com.config.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
