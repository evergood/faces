package com.egar.store.service;

import com.egar.store.domen.Item;
import com.egar.store.util.XmlParser;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ApplicationScoped
@Slf4j
public class ItemService implements Serializable {

    String itemsFileName = "items.xml";

    @Inject
    private XmlParser xmlParser;

    public List<Item> getItems() throws Exception {
        List<Item> items = xmlParser.parseItems(itemsFileName).getItems();
        return items;
    }
}
