package fr.tartur.werewolf.common.game.characters;

import fr.tartur.werewolf.common.ChatColor;
import lombok.Getter;
import lombok.experimental.Accessors;
import net.kyori.adventure.text.Component;

/**
 * Enumeration containing all the Werewolf playable characters.
 */
@Getter
@Accessors(fluent = true)
public enum CharacterType {

    VILLAGER(Component.text("Villageois").color(ChatColor.YELLOW.color())),
    WEREWOLF(Component.text("Loup-Garou").color(ChatColor.DARK_RED.color())),
    CUPID(Component.text("Cupidon").color(ChatColor.PINK.color())),
    WITCH(Component.text("La Sorcière").color(ChatColor.PURPLE.color())),
    LITTLE_GIRL(Component.text("La Petite Fille").color(ChatColor.BLUE.color())),
    STEALER(Component.text("Le Voleur").color(ChatColor.DARK_CYAN.color())),
    HUNTER(Component.text("Le Chasseur").color(ChatColor.GREEN.color())),
    CLAIRVOYANT(Component.text("La Voyante").color(ChatColor.INDIGO.color())),
    UNCHOSEN(Component.text("Non choisi").color(ChatColor.GRAY.color()));

    private final Component display;

    CharacterType(Component display) {
        this.display = display;
    }

}
