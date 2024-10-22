package fr.tartur.werewolf.events;

import fr.tartur.werewolf.items.common.ClickableItemInventoryOpener;
import fr.tartur.werewolf.items.common.gui.GUIAdapter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.List;

public class InventoryOpenerListener implements Listener {

    private final List<Class<? extends ClickableItemInventoryOpener<? extends GUIAdapter>>> items;

    public InventoryOpenerListener(List<Class<? extends ClickableItemInventoryOpener<? extends GUIAdapter>>> items) {
        this.items = items;
    }

    @EventHandler
    public void onRightClickWithItem(PlayerInteractEvent event) {
        // TODO: Complete this method which has to spot every ClickableItemInventoryOpener.
    }

}
