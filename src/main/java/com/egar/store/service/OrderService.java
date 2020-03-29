package com.egar.store.service;

import com.egar.store.dao.impl.OrderDaoImpl;
import com.egar.store.domen.Order;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class OrderService {

    @Inject
    private OrderDaoImpl orderDao;

    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }
}
