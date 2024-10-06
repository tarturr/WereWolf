package fr.tartur.werewolf.exception;

public class IllegalGUIStateException extends IllegalStateException {

    public IllegalGUIStateException() {
        super("The inventory was unexpectedly modified.");
    }

}
