package fr.tartur.werewolf.gui.common;

import fr.tartur.werewolf.WereWolf;
import fr.tartur.werewolf.exception.InvalidGUICoordinatesException;
import fr.tartur.werewolf.exception.InvalidGUISizeException;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GUIAdapter implements InventoryHolder {

    private final Inventory inventory;

    @Getter
    @Accessors(fluent = true)
    private final GUI gui;

    public GUIAdapter(WereWolf main, GUI gui) {
        this.gui = gui;
        final int guiSize = this.gui.size();

        if (guiSize < 1 || guiSize > 6) {
            throw new InvalidGUISizeException(guiSize);
        }

        this.inventory = main.getServer().createInventory(this, guiSize * 9);

        for (final GUIItem item : this.gui.components()) {
            final int componentX = item.x();
            final int componentY = item.y();

            if (componentX < 0 || componentX > 8 || componentY < 0 || componentY >= guiSize) {
                throw new InvalidGUICoordinatesException(guiSize, componentX, componentY);
            }

            final int coordinates = item.x() + 9 * item.y();

            this.inventory.setItem(coordinates, new GUIItemAdapter(item));
        }
    }

    @Override
    public @NotNull Inventory getInventory() {
        return this.inventory;
    }

    public GUIItem select(ItemStack item) {
        return this.gui.select(item);
    }

}
