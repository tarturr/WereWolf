package fr.tartur.werewolf.exception;

public class InvalidGUICoordinatesException extends IllegalArgumentException {

    public InvalidGUICoordinatesException(int inventorySize, int providedX, int providedY) {
        super("Invalid coordinates { x: " + providedX + ", y: " + providedY + " } for inventory of size: { x: 9, y: " +
                inventorySize + " }!");
    }

}
