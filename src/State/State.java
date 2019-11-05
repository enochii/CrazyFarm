package State;

import Livings.Living;

import java.io.Serializable;

/**
 * The interface State.
 */
public interface State extends Serializable {

    /**
     * Gets full state.
     *
     * @param context the context
     */
    public void getFullState(Context context);

    /**
     * Gets hungry state.
     *
     * @param context the context
     */
    public void getHungryState(Context context);

    /**
     * Gain experience.
     *
     * @param living the living
     */
    public void gainExperience(Living living);



}
