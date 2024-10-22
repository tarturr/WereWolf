package fr.tartur.werewolf.items.common.gui;

import fr.tartur.werewolf.exception.InvalidGUICoordinatesException;
import fr.tartur.werewolf.exception.InvalidGUISizeException;
import fr.tartur.werewolf.items.common.ClickableItemAdapter;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Class based on the Adapter design pattern, used to easily deal with {@code Inventory} and {@code GUI} classes.
 * @see Inventory
 * @see GUI
 */
public class GUIAdapter implements InventoryHolder {

    private final Inventory inventory;

    @Getter
    @Accessors(fluent = true)
    private final GUI gui;

    /**
     * Class constructor, creating a new {@code GUI}.
     * @param gui The {@code GUI} that will be registered directly into the plugin.
     * @see GUI
     */
    public GUIAdapter(GUI gui) {
        this.gui = gui;
        final int guiSize = this.gui.size();

        if (guiSize < 1 || guiSize > 6) {
            throw new InvalidGUISizeException(guiSize);
        }

        this.inventory = Bukkit.getServer().createInventory(this, guiSize * 9);

        for (final GUIItem clickableItem : this.gui.components()) {
            final int componentX = clickableItem.x();
            final int componentY = clickableItem.y();

            if (componentX < 0 || componentX > 8 || componentY < 0 || componentY >= guiSize) {
                throw new InvalidGUICoordinatesException(guiSize, componentX, componentY);
            }

            final int coordinates = clickableItem.x() + 9 * clickableItem.y();

            this.inventory.setItem(coordinates, new ClickableItemAdapter(clickableItem));
        }
    }

    /**
     * Gets the {@code Inventory} associated with the class {@code GUI}.
     * @return The {@code Inventory} associated with the class {@code GUI}.
     * @see Inventory
     * @see GUI
     */
    @Override
    public @NotNull Inventory getInventory() {
        return this.inventory;
    }

    /**
     * Gets the {@code GUIItem} associated with the provided {@code ItemStack}.
     * @param item The provided {@code ItemStack} which corresponds to a {@code GUIItem} in the GUI.
     * @return The {@code GUIItem} associated with the provided {@code ItemStack}.
     * @see GUIItem
     * @see ItemStack
     */
    public GUIItem select(ItemStack item) {
        return this.gui.select(item);
    }

}
