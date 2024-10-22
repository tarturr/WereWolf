package fr.tartur.werewolf.exception;

import fr.tartur.werewolf.items.common.gui.GUI;

/**
 * Child class of the {@code IllegalStateException} class, thrown when all of the components of the GUI are not present
 * as expected.
 * @see IllegalStateException
 * @see GUI
 */
public class IllegalGUIStateException extends IllegalStateException {

    /**
     * Class constructor with default message: {@code "The inventory was unexpectedly modified."}.
     */
    public IllegalGUIStateException() {
        super("The inventory was unexpectedly modified.");
    }

}
