package com.egar.store.dao.impl;

import com.egar.store.dao.OrderDao;
import com.egar.store.domen.Order;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
@ApplicationScoped
@RequiredArgsConstructor
public class OrderDaoImpl implements OrderDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Order> getAllOrders() {
        return entityManager.createQuery("SELECT order FROM Order order", Order.class).getResultList();
    }

    @Override
    public void placeOrder(Order order) {

    }
}
