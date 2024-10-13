package fr.tartur.werewolf.common.game;

import fr.tartur.werewolf.WereWolfCore;
import io.papermc.paper.threadedregions.scheduler.ScheduledTask;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.function.Supplier;

/**
 * Represents a timer of 60 seconds which will send a result of the provided type T at the end of its lifetime.
 * @param <T> The type of the result this class will return at the end of the timer lifetime.
 */
public class DelayedResult<T> {

    private final Supplier<T> resultComputer;

    private ScheduledTask task;
    private int timer;
    private final PropertyChangeSupport support;

    /**
     * Class constructor, which initializes the concerned timer.
     * @param result Function which will return a single result based on abritrary calculations
     * @param listener Class waiting for the timer to send any notification.
     */
    public DelayedResult(Supplier<T> result, PropertyChangeListener listener) {
        this.resultComputer = result;
        this.timer = 60;
        this.support = new PropertyChangeSupport(this);
        this.support.addPropertyChangeListener(listener);
    }

    /**
     * Starts the vote timer with a lifetime of 60 seconds.
     * @param main The plugin instance in which the timer will run.
     */
    public void start(WereWolfCore main) {
        this.task = main.getServer().getGlobalRegionScheduler().runAtFixedRate(main, task -> {
            this.support.firePropertyChange("timer", this.timer, --this.timer);

            if (this.timer == 0) {
                task.cancel();
                this.support.firePropertyChange("result", null, this.resultComputer.get());
            }
        }, 0L, 20L);
    }

    /**
     * Forces the timer to go to 5s left even if it has not reached 0 yet. Works only if the timer is not under 5s left
     * yet.
     * @throws UnsupportedOperationException If the timer was already cancelled.
     */
    public void end() {
        if (this.hasTimerEnded()) {
            throw new UnsupportedOperationException("Cannot stop timer when it already was.");
        }

        if (this.timer > 5) {
            this.timer = 5;
        }
    }

    /**
     * Stops the timer and resets it back to 60s.
     */
    public void reset() {
        this.task.cancel();
        final int old = this.timer;
        this.timer = 60;
        this.support.firePropertyChange("timer", old, this.timer);
    }

    /**
     * Returns {@code true} if the timer was already stopped, {@code false} otherwise.
     * @return {@code true} if the timer was already stopped, {@code false} otherwise.
     */
    public boolean hasTimerEnded() {
        return this.task.isCancelled();
    }

    /**
     * Gets the result.
     * @throws UnsupportedOperationException If the timer was still running.
     * @return The final result as {@code T}.
     * @see T
     */
    public T results() {
        if (!this.hasTimerEnded()) {
            throw new UnsupportedOperationException("Cannot get results before the end of the timer.");
        }

        return this.resultComputer.get();
    }

}
