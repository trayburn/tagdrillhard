package com.improving.commands;

import com.improving.domain.GameContext;
import org.springframework.stereotype.Component;

@Component
public class MoveCommand implements Command {
    private final GameContext context;

    public MoveCommand(GameContext context) {
        this.context = context;
    }

    @Override
    public boolean isValid(String input) {
        return input.split(" ")[0].equalsIgnoreCase("move");
    }
    @Override
    public void execute(String input) {
        var dest = input.split(" ")[1];
        var newLocation = context.getPlayer().getLocation().getExits().stream()
                .filter(e -> e.getName().equalsIgnoreCase(dest))
                .findFirst()
                .orElseThrow()
                .getDestination();
        context.getPlayer().setLocation(newLocation);
    }
}
