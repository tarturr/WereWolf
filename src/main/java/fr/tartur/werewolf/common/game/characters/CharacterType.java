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

    CLAIRVOYANT("Voyante", Component.text("La Voyante").color(ChatColor.INDIGO.color())),
    CUPID("Cupidon", Component.text("Cupidon").color(ChatColor.PINK.color())),
    HUNTER("Chasseur", Component.text("Le Chasseur").color(ChatColor.GREEN.color())),
    LITTLE_GIRL("La Petite Fille", Component.text("La Petite Fille").color(ChatColor.BLUE.color())),
    STEALER("Le Voleur", Component.text("Le Voleur").color(ChatColor.DARK_CYAN.color())),
    VILLAGER("Villageois", Component.text("Villageois").color(ChatColor.YELLOW.color())),
    WEREWOLF("Loup-Garou", Component.text("Loup-Garou").color(ChatColor.DARK_RED.color())),
    WITCH("La Sorcière", Component.text("La Sorcière").color(ChatColor.PURPLE.color())),

    UNCHOSEN("Non choisi", Component.text("Non choisi").color(ChatColor.GRAY.color()));

    private final String name;
    private final Component display;

    CharacterType(String name, Component display) {
        this.name = name;
        this.display = display;
    }

}
