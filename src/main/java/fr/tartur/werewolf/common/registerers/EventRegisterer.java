package fr.tartur.werewolf.common.registerers;

import fr.tartur.werewolf.WereWolf;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

public class EventRegisterer extends BaseRegisterer<Listener> {

    public EventRegisterer(Listener... elements) {
        super(elements);
    }

    @Override
    public void registerAll(WereWolf main) {
        PluginManager manager = main.getServer().getPluginManager();
        super.elements.forEach(listener -> manager.registerEvents(listener, main));
    }

}
