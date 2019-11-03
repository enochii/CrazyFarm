package State;

import Livings.Living;

/**
 * The type Animal hungry state.
 */
public class AnimalHungryState implements State{
    private static AnimalHungryState singleton = new AnimalHungryState();
    private AnimalHungryState(){}

    /**
     * Get instance state.
     *
     * @return the state
     */
    public static State getInstance(){
        return singleton;
    }
    public void getFullState(Context context){
        context.changeState(AnimalFullState.getInstance());

    }

    public void getHungryState(Context context){

    }

    public void gainExperience(Living living){

    }

}
