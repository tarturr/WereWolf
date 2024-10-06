package fr.tartur.werewolf.exception;

public class InvalidGUISizeException extends IllegalArgumentException {

    public InvalidGUISizeException(int providedSize) {
        super("Invalid size of rows: " + providedSize + " for an inventory. Size must be greater or equal to " +
                "1 and less or equal to 6.");
    }

}
