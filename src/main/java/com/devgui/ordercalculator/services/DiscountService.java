package com.devgui.ordercalculator.services;

import com.devgui.ordercalculator.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {
    public double calculateDiscount(Order order) {
        return order.getBasic() * (order.getDiscount() / 100);
    }
}
