package com.egar.store.dao.impl;

import com.egar.store.dao.OrderDao;
import com.egar.store.domen.Order;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class OrderDaoImpl implements OrderDao {

private EntityManager entityManager;

    @Override
    public List<Order> getAllOrders() {
        return entityManager.createQuery("SELECT order FROM Order order", Order.class).getResultList();
    }

    @Override
    public void placeOrder(Order order) {

    }
}
