package com.devgui.ordercalculator;

import com.devgui.ordercalculator.entities.Order;
import com.devgui.ordercalculator.services.DiscountService;
import com.devgui.ordercalculator.services.OrderService;
import com.devgui.ordercalculator.services.ShippingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderCalculatorApplication implements CommandLineRunner {

    private OrderService orderService;
    public OrderCalculatorApplication(OrderService orderService) {
        this.orderService = orderService;
    }
    public static void main(String[] args) {
        SpringApplication.run(OrderCalculatorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Order firstOrder = new Order(1034, 150.00, 20.00);
        Order secondOrder = new Order(2282, 800.00, 10.00);
        Order thirdOrder = new Order(1309, 95.90, 0.00);

        Order[] orders;
        orders = new Order[]{firstOrder, secondOrder,thirdOrder};
        for(Order order : orders) {
            System.out.printf("Order code %d\n", order.getCode());
            System.out.printf("Total value: R$ %.2f\n", orderService.total(order));
        }
    }
}
