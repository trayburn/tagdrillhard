package com.improving.commands;

import com.improving.domain.GameContext;
import org.springframework.stereotype.Component;

@Component
public class PickupCommand implements Command {
    private final GameContext context;

    public PickupCommand(GameContext context) {
        this.context = context;
    }

    @Override
    public boolean isValid(String input) {
        return input.split(" ")[0].equalsIgnoreCase("pickup");
    }
    @Override
    public void execute(String input) {
        var item = input.split(" ")[1];
        var itemToPickup = context.getPlayer().getLocation()
                .getItems().stream()
                .filter(e -> e.getName().equalsIgnoreCase(item))
                .findFirst()
                .orElseThrow();
        context.getPlayer().getLocation().getItems().remove(itemToPickup);
        context.getPlayer().getItems().add(itemToPickup);
    }
}
