package State;


import Livings.Living;

/**
 * The type Animal full state.
 */
public class AnimalFullState implements State{

    private static AnimalFullState singleton = new AnimalFullState();
    private AnimalFullState(){

    }

    /**
     * 获取温饱状态的实例
     *
     * @return the state
     */
    public static State getInstance(){
        return singleton;
    }

    /**
     * 本来就是温饱状态，不做任何操作
     *
     * @return the state
     */
    public void getFullState(Context context){

    }

    /**
     * 改变为饥饿状态
     *
     * @return the state
     */
    public void getHungryState(Context context){
        System.out.println("======== 使用 State 模式 ========");
        System.out.println("AnimalFullState : " + this.hashCode() +  " :getHungryState: change full state to hungry state");
        context.changeState(AnimalHungryState.getInstance());
    }

    /**
     * 温饱状态下增加经验值
     *
     * @return the state
     */
    public void gainExperience(Living living){
        System.out.println("======== 使用 State 模式 ========");
        System.out.println("AnimalFullState : " + this.hashCode() +  " :gainExperience: animal gain experience");
        living._experience++;
    }
}
