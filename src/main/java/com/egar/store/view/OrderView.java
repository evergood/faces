package com.egar.store.view;

import com.egar.store.domen.Order;
import com.egar.store.service.OrderService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.soap.SOAPException;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Named
@SessionScoped
public class OrderView implements Serializable {

    private List<Order> orders;

    @Inject
    private OrderService orderService;

    @PostConstruct
    public void init() {
        orders = orderService.getAllOrders();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public LocalDateTime getDate() throws IOException, SOAPException {
        return orderService.getSoapDate();
    }
}
