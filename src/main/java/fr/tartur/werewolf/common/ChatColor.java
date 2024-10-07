package fr.tartur.werewolf.common;

import lombok.Getter;
import lombok.experimental.Accessors;
import net.kyori.adventure.text.format.TextColor;

/**
 * An enum regrouping multiple colors with differents tones. Usable as TextColor, avoiding the verbosity of
 * {@code TextColor.color()} static method.
 */
@Accessors(fluent = true)
@Getter
public enum ChatColor {

    LIGHT_RED(TextColor.color(0xFF7777)),
    LIGHT_ORANGE(TextColor.color(0xFFBB77)),
    LIGHT_YELLOW(TextColor.color(0xFFEE77)),
    LIGHT_GREEN(TextColor.color(0x77FF77)),
    LIGHT_CYAN(TextColor.color(0x77FFFF)),
    LIGHT_BLUE(TextColor.color(0x77DDFF)),
    LIGHT_INDIGO(TextColor.color(0x7777FF)),
    LIGHT_PURPLE(TextColor.color(0xBB77FF)),
    LIGHT_PINK(TextColor.color(0xFFAAFF)),
    LIGHT_GRAY(TextColor.color(0xE7E7E7)),

    RED(TextColor.color(0xEE0000)),
    ORANGE(TextColor.color(0xFF7700)),
    YELLOW(TextColor.color(0xFFDF00)),
    GREEN(TextColor.color(0x00DF00)),
    CYAN(TextColor.color(0x00FFFF)),
    BLUE(TextColor.color(0x00BBFF)),
    INDIGO(TextColor.color(0x0000FF)),
    PURPLE(TextColor.color(0xAA00FF)),
    PINK(TextColor.color(0xFF77FF)),
    GRAY(TextColor.color(0xBBBBBB)),

    DARK_RED(TextColor.color(0xBB0000)),
    DARK_ORANGE(TextColor.color(0xDD7700)),
    DARK_YELLOW(TextColor.color(0xEED000)),
    DARK_GREEN(TextColor.color(0x0D000)),
    DARK_CYAN(TextColor.color(0x00BBBB)),
    DARK_BLUE(TextColor.color(0x0077BB)),
    DARK_INDIGO(TextColor.color(0x0000BB)),
    DARK_PURPLE(TextColor.color(0x8800D0)),
    DARK_PINK(TextColor.color(0xDD00DD)),
    DARK_GRAY(TextColor.color(0x909090)),

    WHITE(TextColor.color(0xFFFFFF)),
    BLACK(TextColor.color(0x000000));

    private final TextColor color;

    ChatColor(TextColor color) {
        this.color = color;
    }

}
