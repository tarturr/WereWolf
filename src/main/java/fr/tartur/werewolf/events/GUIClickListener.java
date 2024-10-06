package fr.tartur.werewolf.events;

import fr.tartur.werewolf.gui.common.GUIAdapter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

import java.util.List;

public class GUIClickListener implements Listener {

    private final List<? extends Class<? extends GUIAdapter>> guis;

    public GUIClickListener(List<? extends Class<? extends GUIAdapter>> guis) {
        this.guis = guis;
    }

    @EventHandler
    public void onClickOnGUI(InventoryClickEvent event) {
        final InventoryHolder holder = event.getInventory().getHolder();

        for (final var guiClass : this.guis) {
            if (guiClass.isInstance(holder)) {
                event.setCancelled(true);

                final GUIAdapter gui = guiClass.cast(holder);
                gui.select(event.getCurrentItem()).onPress().accept(event);
                event.getWhoClicked().closeInventory();
            }
        }
    }

}
