package fr.tartur.werewolf.common.registerers;

import fr.tartur.werewolf.WereWolfCore;
import org.bukkit.command.CommandExecutor;

import java.util.Objects;

/**
 * A Bukkit command registerer, child class of the {@code BaseRegisterer} class, working with its internal
 * {@code CommandDefinition} record.
 * @see fr.tartur.werewolf.common.registerers.BaseRegisterer
 * @see CommandRegisterer.CommandDefinition
 */
public class CommandRegisterer extends BaseRegisterer<CommandRegisterer.CommandDefinition> {

    /**
     * The record containing the name and the executor of each provided Bukkit command.
     * @param name The command name, linked to the plugin.yml file.
     * @param executor The {@code CommandExecutor} implementation of this command.
     * @see CommandExecutor
     */
    public record CommandDefinition(String name, CommandExecutor executor) {}

    /**
     * Class constructor taking as many {@code CommandDefinition} instances as needed.
     * @param commands Every {@code CommandDefinition} needed to be registered into the plugin.
     * @see CommandDefinition
     */
    public CommandRegisterer(CommandDefinition... commands) {
        super(commands);
    }

    /**
     * The method which has to register all {@code CommandExecutor} which needs an instance to {@code JavaPlugin} to be
     * registered.
     * @param main The {@code JavaPlugin} instance ({@code WereWolf} in that case).
     * @see org.bukkit.plugin.java.JavaPlugin
     * @see WereWolfCore
     */
    public void registerAll(WereWolfCore main) {
        super.elements.forEach(
                command -> Objects.requireNonNull(main.getCommand(command.name()), "The /" + command.name() +
                                "was not declared in plugin.yml!")
                        .setExecutor(command.executor())
        );
    }

}
