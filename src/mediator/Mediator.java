package mediator;

import Farm.Farm;

import java.io.Serializable;

/**
 * The interface Mediator.
 */
public interface Mediator extends Serializable{
    /**
     * Create colleagues.
     */
    public abstract void createColleagues();

    /**
     * Colleague changed.
     */
    public abstract void colleagueChanged();
}
