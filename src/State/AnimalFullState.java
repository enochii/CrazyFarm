package State;


import Livings.Living;

public class AnimalFullState implements State{

    private static AnimalFullState singleton = new AnimalFullState();
    private AnimalFullState(){

    }

    public static State getInstance(){
        return singleton;
    }

    public void getFullState(Context context){

    }

    public void getHungryState(Context context){
        context.changeState(AnimalHungryState.getInstance());
    }

    public void gainExperience(Living living){
        living._experience++;
    }



}
