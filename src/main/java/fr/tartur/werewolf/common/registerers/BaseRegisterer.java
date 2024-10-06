package fr.tartur.werewolf.common.registerers;

import fr.tartur.werewolf.WereWolf;

import java.util.Arrays;
import java.util.List;

public abstract class BaseRegisterer<T> {

    protected final List<T> elements;

    protected BaseRegisterer(T[] elements) {
        this.elements = Arrays.asList(elements);
    }

    public abstract void registerAll(WereWolf main);

}
