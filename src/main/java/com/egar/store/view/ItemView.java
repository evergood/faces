package com.egar.store.view;

import com.egar.store.domen.Item;
import com.egar.store.service.ItemService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ItemView implements Serializable {

    private List<Item> items;

    @Inject
    private ItemService itemService;

    @PostConstruct
    public void init() throws Exception {
        items = itemService.getItems();
    }

    public List<Item> getItems() {
        return items;
    }

    public Item getOrderDetailInfo(String serialNumber) throws Exception {
        return itemService.getItemBySerialNumber(serialNumber);
    }

    public String getItemInfo(String serialNumber) throws Exception {
        return itemService.getItemInfoBySerialNumber(serialNumber);
    }
}
