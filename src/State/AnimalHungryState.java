package State;

import Livings.Living;

public class AnimalHungryState implements State{
    private static AnimalHungryState singleton = new AnimalHungryState();
    private AnimalHungryState(){}
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
