package action;

/**
 * 鸡进食动作
 */
public class ChickenEat implements MakeEatingAction {

    @Override
    public void doAction() {
        makeEatingAction();
    }

    @Override
    public void makeEatingAction() {
        System.out.println("Chicken is eating.");
    }
}
