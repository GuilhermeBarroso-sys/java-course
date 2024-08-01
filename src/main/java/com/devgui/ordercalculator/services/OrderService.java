package com.devgui.ordercalculator.services;

import com.devgui.ordercalculator.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    DiscountService discountService;
    ShippingService shippingService;
    public OrderService(ShippingService shippingService, DiscountService discountService) {
        this.shippingService = shippingService;
        this.discountService = discountService;
    }
    public double total(Order order) {
        double discount = discountService.calculateDiscount(order);
        double priceWithDiscount = order.getBasic() - discount;
        order.setBasic(priceWithDiscount);
        double shipping = shippingService.shipment(order);
        return priceWithDiscount + shipping;
    }
}
