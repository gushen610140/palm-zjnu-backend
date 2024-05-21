package icu.sunway.palmzjnubackend.controller;

import icu.sunway.palmzjnubackend.pojo.OrdersPojo;
import icu.sunway.palmzjnubackend.pojo.PostedOrderPojo;
import icu.sunway.palmzjnubackend.pojo.Status;
import icu.sunway.palmzjnubackend.service.OrdersService;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "api/order", method = RequestMethod.POST)
    public Status addOrder(@RequestBody PostedOrderPojo order) {
        return ordersService.addOrder(order.getUser_id(), order.getTotal_price());
    }


}
