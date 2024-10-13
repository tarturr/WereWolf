package fr.tartur.werewolf.common.registerers;

import fr.tartur.werewolf.WereWolfCore;

import java.util.Arrays;
import java.util.List;

/**
 * Abstract class regrouping any data structure type which needs an instance of {@code JavaPlugin} to be registered.
 * @param <T> The data structure.
 * @see org.bukkit.plugin.java.JavaPlugin
 */
public abstract class BaseRegisterer<T> {

    protected final List<T> elements;

    /**
     * Class constructor.
     * @param elements Every elements needing the {@code JavaPlugin} instance.
     * @see org.bukkit.plugin.java.JavaPlugin
     */
    protected BaseRegisterer(T[] elements) {
        this.elements = Arrays.asList(elements);
    }

    /**
     * The method which has to register all class elements needing the {@code JavaPlugin} instance to be registered.
     * @param main The {@code JavaPlugin} instance ({@code WereWolf} in that case).
     * @see org.bukkit.plugin.java.JavaPlugin
     * @see WereWolfCore
     */
    public abstract void registerAll(WereWolfCore main);

}
