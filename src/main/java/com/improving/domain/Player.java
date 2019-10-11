package com.improving.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Location location;
    private final List<Item> items = new ArrayList<>();

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Item> getItems() {
        return items;
    }
}
