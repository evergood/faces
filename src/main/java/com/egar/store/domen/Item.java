package com.egar.store.domen;

import lombok.Data;

import java.util.Date;

@Data
public class Item {
    private String serialNumber;

    private String name;

    private String description;

    private Date manufactureDate;

    private OrderDetail orderDetail;

}
