package com.dhruv.warehouse;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class InventoryProcessor {

    public static ItemInfoProvider  safeLookup(String id) {
        return Optional.ofNullable(Inventory.findItem(id))
                .<ItemInfoProvider>map(inv -> inv)
                .orElseGet(ItemPlaceholder::new);
    }

    public static Set<String> extractUniqueIds(Inventory inventory) {
        return inventory.getPalletItemIds()
                .stream()
                .flatMap(pallet -> pallet.stream())
                .collect(Collectors.toSet());
    }


}