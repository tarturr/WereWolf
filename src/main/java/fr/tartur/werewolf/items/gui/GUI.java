package fr.tartur.werewolf.items.gui;

import fr.tartur.werewolf.exception.IllegalGUIStateException;
import fr.tartur.werewolf.items.ClickableItem;
import fr.tartur.werewolf.items.ClickableItemAdapter;
import lombok.Builder;
import lombok.Singular;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * Record representing a GUI in Minecraft, which means a static {@code Inventory} with no owner.
 * @param title GUI title as {@code Component}.
 * @param size GUI rows count. Must be in range 1 to 6 (inclusive).
 * @param components Each {@code GUIItem} component of the Inventory. Be aware that each {@code GUIItem} coordinates out
 *                   of bounds of the GUI will throw an {@code InvalidGUICoordinatesException}.
 * @see org.bukkit.inventory.Inventory
 * @see ClickableItem
 * @see fr.tartur.werewolf.exception.InvalidGUICoordinatesException
 */
@Builder
public record GUI(Component title, int size, @Singular List<ClickableItem> components) {

    /**
     * Gets the {@code GUIItem} associated with the provided {@code ItemStack}.
     * @param item The provided {@code ItemStack} which corresponds to a {@code GUIItem} in the GUI.
     * @return The {@code GUIItem} associated with the provided {@code ItemStack}.
     * @see ClickableItem
     * @see ItemStack
     */
    public ClickableItem select(ItemStack item) {
        return this.components.stream()
                .map(ClickableItemAdapter::new)
                .filter(guiItem -> guiItem.getItemMeta().itemName().equals(item.getItemMeta().itemName()))
                .findFirst()
                .orElseThrow(IllegalGUIStateException::new)
                .clickableItem();

    }

}
