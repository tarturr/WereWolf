package fr.tartur.werewolf.events;

import fr.tartur.werewolf.items.common.gui.GUIAdapter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

import java.util.List;

/**
 * Class implementing {@code Listener}, reacting to every {@code InventoryClickEvent} trigger.
 * @see Listener
 * @see InventoryClickEvent
 */
public class GUIClickListener implements Listener {

    private final List<Class<? extends GUIAdapter>> guis;

    /**
     * Class constructor taking a list of the {@code Class<? extends GUIAdapter>} objects.
     * @param guis {@code List} of each {@code Class<? extends GUIAdapter>} of each {@code GUIAdapter}.
     * @see GUIAdapter
     */
    public GUIClickListener(List<Class<? extends GUIAdapter>> guis) {
        this.guis = guis;
    }

    /**
     * The method triggered for each {@code InventoryClickEvent} but reacts only if the concerned inventory is an
     * instance of any class from the provided classes in the constructor.
     * @param event The {@code InventoryClickEvent} triggered each time a {@code Player} interacts with an
     * {@code Inventory}.
     * @see InventoryClickEvent
     */
    @EventHandler
    public void onClickOnGUI(InventoryClickEvent event) {
        final InventoryHolder holder = event.getInventory().getHolder();

        for (final var guiClass : this.guis) {
            if (guiClass.isInstance(holder)) {
                event.setCancelled(true);

                final GUIAdapter gui = guiClass.cast(holder);
                gui.select(event.getCurrentItem()).onPress().onLeftClick(event);
                event.getWhoClicked().closeInventory();
            }
        }
    }

}
