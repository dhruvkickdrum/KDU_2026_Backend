package com.dhruv.warehouse;

public class ItemPlaceholder implements ItemInfoProvider {
    public ItemPlaceholder() {
        System.out.println("Alert: Creating expensive placeholder object!");
    }
    public String getInfo() { return "ID-NOT-FOUND : Placeholder Item"; }
}
