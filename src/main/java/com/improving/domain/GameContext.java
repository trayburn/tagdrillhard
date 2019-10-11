package com.improving.domain;

import org.springframework.stereotype.Component;

@Component
public class GameContext {
    private Player player = new Player();
    private Location startingLocation = buildWorld();

    public GameContext() {
        player.setLocation(startingLocation);
    }

    public Player getPlayer() {
        return player;
    }

    public Location getStartingLocation() {
        return startingLocation;
    }

    private Location buildWorld() {
        var forest = new Location("Forest");
        var treehouse = new Location("Treehouse");
        var lake = new Location("Lake");

        treehouse.getExits().add(new Exit("zipline", lake));
        forest.getExits().add(new Exit("up", treehouse));
        treehouse.getExits().add(new Exit("down", forest));
        lake.getExits().add(new Exit("south", forest));
        forest.getExits().add(new Exit("north", lake));

        forest.getItems().add(new Item("Ring"));

        return forest;
    }

}
