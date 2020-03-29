package com.egar.store.service;

import com.egar.store.domen.Item;
import com.egar.store.util.Parser;
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
    private Parser parser;

    public List<Item> getItems() throws Exception {
        List<Item> items = parser.parseItems(itemsFileName).getItems();
        log.debug("///Items loaded////");
        return items;
    }
}
