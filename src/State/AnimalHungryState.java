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

    /**
     * 饥饿状态变为温饱状态
     *
     * @return the state
     */
    public void getFullState(Context context){

        System.out.println("======== 使用 State 模式 ========");
        System.out.println("AnimalHungryState : " + this.hashCode() +  " :getFullState: change hungry state to full state");
        context.changeState(AnimalFullState.getInstance());

    }

    /**
     * 饥饿状态下不做任何操作
     *
     * @param context the context
     */
    public void getHungryState(Context context){

    }

    /**
     * 饥饿状态下不增加经验值
     *
     * @param living the context
     */
    public void gainExperience(Living living){

    }

}
