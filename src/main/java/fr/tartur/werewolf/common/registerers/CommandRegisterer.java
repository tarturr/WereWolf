package fr.tartur.werewolf.common.registerers;

import fr.tartur.werewolf.WereWolf;
import org.bukkit.command.CommandExecutor;

import java.util.Objects;

public class CommandRegisterer extends BaseRegisterer<CommandRegisterer.CommandDefinition> {

    public record CommandDefinition(String name, CommandExecutor executor) {}

    public CommandRegisterer(CommandDefinition... commands) {
        super(commands);
    }

    public void registerAll(WereWolf main) {
        super.elements.forEach(
                command -> Objects.requireNonNull(main.getCommand(command.name()), "The /" + command.name() + "was not declared in plugin.yml!")
                        .setExecutor(command.executor())
        );
    }

}
