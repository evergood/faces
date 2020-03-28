package com.egar.store.dao;

import com.egar.store.domen.OrderDetail;

public interface OrderDetailDao {

    public OrderDetail getDetailByOrderId(Integer orderId);
}
