package com.improving.domain;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private String name;
    private List<Exit> exits = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Exit> getExits() {
        return exits;
    }
}
