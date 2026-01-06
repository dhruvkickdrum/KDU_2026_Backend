package com.dhruv.warehouse;

import java.util.List;
import java.util.Optional;

public class Inventory implements ItemInfoProvider {
    private final String name;
    private final List<List<String>> palletItemIds;

    public Inventory(String name, List<List<String>> palletItemIds) {
        this.name = name;
        this.palletItemIds = palletItemIds;
    }

    public String getName() {
        return name;
    }

    public List<List<String>> getPalletItemIds() {
        return palletItemIds;
    }

    @Override
    public String getInfo() {
        return "FOUND: Inventory = " + name;
    }


    public static Inventory findItem(String id) {
        if(id.equals("A100")) {
            return new Inventory("Main Inventory", List.of(
                    List.of("P10", "P20"),
                    List.of("P30", "P10", "P40")
            ));
        }
        return null;
    }

}
