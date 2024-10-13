package fr.tartur.werewolf.common.registerers;

import fr.tartur.werewolf.WereWolfCore;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

/**
 * A Bukkit event registerer, child class of the {@code BaseRegisterer} class.
 * @see fr.tartur.werewolf.common.registerers.BaseRegisterer
 * @see Listener
 */
public class EventRegisterer extends BaseRegisterer<Listener> {

    /**
     * Class constructor taking as many {@code Listener} instances as needed.
     * @param listeners Every {@code Listener} needed to be registered into the plugin.
     * @see Listener
     */
    public EventRegisterer(Listener... listeners) {
        super(listeners);
    }

    /**
     * The method which has to register all {@code Listener} which needs an instance to {@code JavaPlugin} to be
     * registered.
     * @param main The {@code JavaPlugin} instance ({@code WereWolf} in that case).
     * @see org.bukkit.plugin.java.JavaPlugin
     * @see WereWolfCore
     */
    @Override
    public void registerAll(WereWolfCore main) {
        PluginManager manager = main.getServer().getPluginManager();
        super.elements.forEach(listener -> manager.registerEvents(listener, main));
    }

}
