package mediator;

/**
 * The interface Colleague.
 */
public interface Colleague {

    /**
     * Sets mediator.
     *
     * @param mediator the mediator
     */
    public abstract void setMediator(Mediator mediator);

    /**
     * Sets colleague enable.
     *
     * @param enable the enable
     */
    public abstract void setColleagueEnable(boolean enable);

    /**
     * Sets colleague updated.
     */
    public abstract void setColleagueUpdated();
}
