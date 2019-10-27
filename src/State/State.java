package State;

import Livings.Living;

public interface State {

    public void getFullState(Context context);
    public void getHungryState(Context context);
    public void gainExperience(Living living);



}
