package com.improving;

import com.improving.commands.Command;
import com.improving.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Game {
    private final Scanner scanner = new Scanner(System.in);
    private final GameContext context;
    private final List<Command> commands;

    public Game(GameContext context, List<Command> commands) {
        this.context = context;
        this.commands = commands;
    }

    public void run() {
        var loop = true;
        while (loop) {
            System.out.print(context.getPlayer().getLocation().getName() + "> ");
            var input = scanner.nextLine();
            for(var cmd : commands) {
                if (cmd.isValid(input)) {
                    cmd.execute(input);
                }
            }
        }
    }
}
