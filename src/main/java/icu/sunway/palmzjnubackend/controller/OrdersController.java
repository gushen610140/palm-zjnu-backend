package icu.sunway.palmzjnubackend.controller;

import icu.sunway.palmzjnubackend.pojo.OrdersPojo;
import icu.sunway.palmzjnubackend.service.OrdersService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @RequestMapping(value = "api/orders", method = RequestMethod.GET)
    public List<OrdersPojo> getAllOrders() {
        return ordersService.getAllOrders();
    }

}
