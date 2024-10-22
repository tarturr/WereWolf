package fr.tartur.werewolf.items.gui;

import fr.tartur.werewolf.common.ChatColor;
import fr.tartur.werewolf.items.common.Clickable;
import fr.tartur.werewolf.items.common.gui.GUIItem;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class WereWolfChoiceItem extends GUIItem {

    private static class Action implements Clickable<InventoryClickEvent> {
        @Override
        public void onLeftClick(InventoryClickEvent event) {
            Player player = (Player) event.getWhoClicked();
            player.sendMessage(Component.text("Vous avez sélectionné le rôle du ")
                    .color(ChatColor.ORANGE.color())
                    .append(Component.text("Loup-Garou")
                            .color(ChatColor.DARK_RED.color()))
                    .append(Component.text(" !")
                            .color(ChatColor.ORANGE.color())));
        }

        @Override
        public void onRightClick(InventoryClickEvent event) {
        }
    }

    protected WereWolfChoiceItem() {
        super(GUIItem.builder()
                .name(Component.text("Loup-Garou")
                        .color(ChatColor.DARK_RED.color()))
                .descriptionLine(Component.text("Tue tout le village sans")
                        .color(ChatColor.LIGHT_INDIGO.color()))
                .descriptionLine(Component.text("te faire démasquer à l'aide de")
                        .color(ChatColor.LIGHT_INDIGO.color()))
                .descriptionLine(Component.text("tes complices loups-garous !")
                        .color(ChatColor.LIGHT_INDIGO.color()))
                .material(Material.BONE)
                .x(4)
                .y(1)
                .onPress(new Action())
                .build());
    }

}
