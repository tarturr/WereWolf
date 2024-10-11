package fr.tartur.werewolf.items.gui;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Class based on the Adapter design pattern, used to easily deal with {@code ItemStack} and {@code GUIItem} classes.
 * @see ItemStack
 * @see GUIItem
 */
@Accessors(fluent = true)
@Getter
public class GUIItemAdapter extends ItemStack {

    private final GUIItem guiItem;

    /**
     * Class constructor working with an instance of a {@code GUIItem}.
     * @param guiItem The instance of {@code GUIItem}, stored in the class.
     */
    public GUIItemAdapter(GUIItem guiItem) {
        super(guiItem.material(), guiItem.amount());
        this.guiItem = guiItem;

        final ItemMeta meta = this.getItemMeta();
        meta.itemName(guiItem.name());
        meta.lore(guiItem.description());
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        if (guiItem.glowEffect()) {
            meta.addEnchant(Enchantment.POWER, 1, true);
        }

        this.setItemMeta(meta);
    }

}
