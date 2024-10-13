package fr.tartur.werewolf.items;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Class based on the Adapter design pattern, used to easily deal with {@code ItemStack} and {@code GUIItem} classes.
 * @see ItemStack
 * @see ClickableItem
 */
@Accessors(fluent = true)
@Getter
public class ClickableItemAdapter extends ItemStack {

    private final ClickableItem clickableItem;

    /**
     * Class constructor working with an instance of a {@code GUIItem}.
     * @param clickableItem The instance of {@code GUIItem}, stored in the class.
     */
    public ClickableItemAdapter(ClickableItem clickableItem) {
        super(clickableItem.material(), clickableItem.amount());
        this.clickableItem = clickableItem;

        final ItemMeta meta = this.getItemMeta();
        meta.itemName(clickableItem.name());
        meta.lore(clickableItem.description());
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        if (clickableItem.glowEffect()) {
            meta.addEnchant(Enchantment.POWER, 1, true);
        }

        this.setItemMeta(meta);
    }

}
