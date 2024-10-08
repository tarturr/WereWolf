package fr.tartur.werewolf.exception;

/**
 * Class representing an exception thrown when any operation is getting executed on a cancelled vote timer.
 */
public class UnsupportedVoteOperationException extends UnsupportedOperationException {

    /**
     * Class constructor with a predefined message informing the developer of its mistake.
     */
    public UnsupportedVoteOperationException() {
        super("Cannot set the timer to 5s left because it was already stopped.");
    }

}
