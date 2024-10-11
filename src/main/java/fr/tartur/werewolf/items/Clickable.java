package fr.tartur.werewolf.items;

import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;

/**
 * Class representing any action tied to an item.
 * @param <T> The event which is triggered on the player's left/right click.
 */
public interface Clickable<T extends Event> {

    /**
     * The event of type {@code T} triggered when the item is left clicked.
     * @param event The triggered event.
     */
    @EventHandler
    void onLeftClick(T event);

    /**
     * The event of type {@code T} triggered when the item is right clicked.
     * @param event The triggered event.
     */
    @EventHandler
    void onRightClick(T event);

}
