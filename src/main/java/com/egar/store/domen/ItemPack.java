package com.egar.store.domen;

import lombok.Data;

import java.util.List;

@Data
public class ItemPack {
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }
}
