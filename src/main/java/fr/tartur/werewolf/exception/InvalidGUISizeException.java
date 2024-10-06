package fr.tartur.werewolf.exception;

/**
 * Child class of the {@code IllegalArgumentException} class, thrown when the provided size of the {@code GUI} is
 * greater than 6 or less than 1.
 * @see IllegalArgumentException
 * @see fr.tartur.werewolf.gui.common.GUI
 */
public class InvalidGUISizeException extends IllegalArgumentException {

    /**
     * Class constructor, logging the falsy provided GUI size with a recall on the possible size range.
     * @param providedSize The falsy provided GUI size.
     */
    public InvalidGUISizeException(int providedSize) {
        super("Invalid size of rows: " + providedSize + " for an inventory. Size must be greater or equal to " +
                "1 and less or equal to 6.");
    }

}
