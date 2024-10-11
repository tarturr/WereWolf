package fr.tartur.werewolf.exception;

/**
 * Child class of the {@code IllegalArgumentException} class, thrown when the provided item coordinates are out of
 * bounds of the {@code GUI} size.
 * @see IllegalArgumentException
 * @see fr.tartur.werewolf.items.gui.GUI
 */
public class InvalidGUICoordinatesException extends IllegalArgumentException {

    /**
     * Class constructor, logging the GUI size and comparing it to the falsy provided values.
     * @param guiSize The GUI size.
     * @param providedX The falsy provided X coordinate of the component.
     * @param providedY The falsy provided Y coordinate of the component.
     */
    public InvalidGUICoordinatesException(int guiSize, int providedX, int providedY) {
        super("Invalid coordinates { x: " + providedX + ", y: " + providedY + " } for inventory of size: { x: 9, y: " +
                guiSize + " }!");
    }

}
