package fr.tartur.werewolf.items;

import fr.tartur.werewolf.common.ChatColor;
import fr.tartur.werewolf.items.common.ClickableItemInventoryOpener;
import fr.tartur.werewolf.items.common.ClickableItem;
import fr.tartur.werewolf.items.gui.CharacterChoiceGUI;
import net.kyori.adventure.text.Component;
import org.bukkit.event.player.PlayerInteractEvent;

public class CharacterChoiceClickableItem extends ClickableItemInventoryOpener<CharacterChoiceGUI> {

    public CharacterChoiceClickableItem(boolean glowEffect) {
        super(ClickableItem.<PlayerInteractEvent>builder()
                .name(Component.text("Choix du personnage").color(ChatColor.YELLOW.color()))
                .x(4)
                .y(0)
                .descriptionLine(Component.text("Fais un clic droit pour").color(ChatColor.INDIGO.color()))
                .descriptionLine(Component.text("choisir ton personnage !").color(ChatColor.INDIGO.color()))
                .glowEffect(glowEffect)
                .build(),
                new CharacterChoiceGUI()
        );
    }

}
