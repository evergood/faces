package com.egar.store.domen;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
@Entity
public class OrderDetail {
    @Id
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "item_serial_number")
    private Item item;

    @Column(name = "amount")
    private Integer amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;
}
