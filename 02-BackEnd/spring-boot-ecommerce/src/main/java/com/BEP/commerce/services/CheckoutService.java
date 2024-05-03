package com.BEP.commerce.services;

import com.BEP.commerce.dto.Purchase;
import com.BEP.commerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
