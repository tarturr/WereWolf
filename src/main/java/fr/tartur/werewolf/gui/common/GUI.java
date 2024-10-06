package fr.tartur.werewolf.gui.common;

import fr.tartur.werewolf.exception.IllegalGUIStateException;
import lombok.Builder;
import lombok.Singular;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@Builder
public record GUI(Component title, int size, @Singular List<GUIItem> components) {

    public GUIItem select(ItemStack item) {
        return this.components.stream()
                .map(GUIItemAdapter::new)
                .filter(guiItem -> guiItem.getItemMeta().itemName().equals(item.getItemMeta().itemName()))
                .findFirst()
                .orElseThrow(IllegalGUIStateException::new)
                .guiItem();

    }

}
