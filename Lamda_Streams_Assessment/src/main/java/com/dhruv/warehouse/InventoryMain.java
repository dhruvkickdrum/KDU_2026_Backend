package com.dhruv.warehouse;

import java.util.Set;

public class InventoryMain {
    public static void main(String[] args) {
        Object result = InventoryProcessor.safeLookup("Z999");
        if(result instanceof Inventory inventory) {
            Set<String> ids = InventoryProcessor.extractUniqueIds(inventory);
            System.out.println("Unique Item Ids : " + ids);
        } else {
            System.out.println(((ItemPlaceholder)result).getInfo());
        }
    }
}
