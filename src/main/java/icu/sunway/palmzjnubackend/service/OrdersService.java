package icu.sunway.palmzjnubackend.service;

import icu.sunway.palmzjnubackend.dao.OrdersDao;
import icu.sunway.palmzjnubackend.pojo.OrdersPojo;
import icu.sunway.palmzjnubackend.pojo.Status;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public Status addOrder(int userId, double totalPrice) {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = time.format(formatter);
        OrdersPojo ordersPojo = new OrdersPojo(null, userId, formattedTime, totalPrice, "下单成功");
        if (ordersDao.insert(ordersPojo) > 0) {
            return Status.SUCCESS;
        } else {
            return Status.ERROR;
        }
    }

}
