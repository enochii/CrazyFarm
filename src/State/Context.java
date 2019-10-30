package State;

/**
 * The interface Context.
 */
public interface Context {


    /**
     * Sets clock.
     *
     * @param currentTime the current time
     */
    public abstract void setClock(int currentTime);

    /**
     * Change state.
     *
     * @param state the state
     */
    public abstract void changeState(State state);

    /**
     * Gets fed.
     *
     * @param currentTime the current time
     */
    public abstract void getFed(int currentTime);

}
