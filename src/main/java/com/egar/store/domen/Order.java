package com.egar.store.domen;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "date")
    private Date date;

    @OneToMany(mappedBy = "orderId", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;
}
