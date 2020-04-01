package com.egar.store.service;

import com.egar.store.dao.impl.OrderDaoImpl;
import com.egar.store.domen.Order;
import com.egar.store.util.SoapParser;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.soap.SOAPException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Named
@ApplicationScoped
public class OrderService {

    @Inject
    private OrderDaoImpl orderDao;

    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    public LocalDateTime getSoapDate() throws IOException, SOAPException {
        return SoapParser.getSoapDate();
    }
}
