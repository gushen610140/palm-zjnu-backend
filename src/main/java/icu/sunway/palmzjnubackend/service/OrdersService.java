package icu.sunway.palmzjnubackend.service;

import icu.sunway.palmzjnubackend.dao.OrdersDao;
import icu.sunway.palmzjnubackend.pojo.OrdersPojo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    private final OrdersDao ordersDao;

    public OrdersService(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    public List<OrdersPojo> getAllOrders() {
        return ordersDao.selectList(null);
    }

}
