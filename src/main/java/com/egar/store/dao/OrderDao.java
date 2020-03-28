package com.egar.store.dao;

import com.egar.store.domen.Order;

import java.util.List;

public interface OrderDao {
    public List<Order> getAllOrders();

    public void placeOrder(Order order);
}
