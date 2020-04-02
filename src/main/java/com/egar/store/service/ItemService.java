package com.egar.store.service;

import com.egar.store.domen.Item;
import com.egar.store.util.XmlParser;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ApplicationScoped
public class ItemService implements Serializable {

    String itemsFileName = "items.xml";

    @Inject
    private XmlParser xmlParser;

    public List<Item> getItems() throws Exception {
        List<Item> items = xmlParser.parseItems(itemsFileName).getItems();
        return items;
    }

    public Item getItemBySerialNumber(String serialNumber) throws Exception {
        return getItems().stream().filter(item -> item.getSerialNumber().equals(serialNumber)).
                collect(Collectors.toList()).get(0);
    }

    public String getItemInfoBySerialNumber(String serialNumber) throws Exception {
        Item item = getItemBySerialNumber(serialNumber);
        return new StringBuilder().append(item.getDescription()).append(" ").append(item.getName())
                .append(" manufactured ").append(item.getManufactureDate()).toString();
    }
}
