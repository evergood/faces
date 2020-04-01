package com.egar.store.util;

import com.egar.store.domen.ItemPack;
import lombok.extern.slf4j.Slf4j;
import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IUnmarshallingContext;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Slf4j
public class XmlParser {

    public ItemPack parseItems(String itemsFileName) throws Exception {
        IBindingFactory bfact = BindingDirectory.getFactory(ItemPack.class);
        IUnmarshallingContext uctx = bfact.createUnmarshallingContext();
        ItemPack itemPack = (ItemPack) uctx.unmarshalDocument(
                this.getClass().getClassLoader().getResourceAsStream(itemsFileName), null);
        log.debug(itemPack.toString());
        return itemPack;
    }
}
