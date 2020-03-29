package com.egar.store.domen;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
@Entity
public class Item {
    @Id
    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "manufacture_date")
    private Date manufactureDate;

    @OneToOne(mappedBy = "item")
    private OrderDetail orderDetail;

}
