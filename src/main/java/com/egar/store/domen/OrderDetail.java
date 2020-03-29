package com.egar.store.domen;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@IdClass(OrderDetail.OrderDetailId.class)
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @Column(name = "row_id")
    private Integer rowId;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "amount")
    private Integer amount;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order orderId;

    @Data
    static
    class OrderDetailId implements Serializable {

        private Integer orderId;


        private Integer rowId;
    }
}
