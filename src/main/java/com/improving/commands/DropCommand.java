package com.improving.commands;

import com.improving.domain.GameContext;
import org.springframework.stereotype.Component;

@Component
public class DropCommand implements Command {
    private final GameContext context;

    public DropCommand(GameContext context) {
        this.context = context;
    }

    @Override
    public boolean isValid(String input) {
        return input.split(" ")[0].equalsIgnoreCase("drop");
    }
    @Override
    public void execute(String input) {
        var item = input.split(" ")[1];
        var itemToDrop = context.getPlayer()
                .getItems().stream()
                .filter(e -> e.getName().equalsIgnoreCase(item))
                .findFirst()
                .orElseThrow();
        context.getPlayer().getItems().remove(itemToDrop);
        context.getPlayer().getLocation().getItems().add(itemToDrop);
    }
}
