package fr.tartur.werewolf.items.common.gui;

import fr.tartur.werewolf.items.common.ClickableItem;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIItem extends ClickableItem<InventoryClickEvent> {
    /**
     * Copy constructor only visible for children classes.
     *
     * @param copy The {@code ClickableItem} (often just a ClickableItem.builder() call) which will be copied to the
     *             child class.
     */
    protected GUIItem(ClickableItem<InventoryClickEvent> copy) {
        super(copy);
    }
}
