package fr.tartur.werewolf.gui.common;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUIItemAdapter extends ItemStack {

    @Getter
    @Accessors(fluent = true)
    private final GUIItem guiItem;

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
