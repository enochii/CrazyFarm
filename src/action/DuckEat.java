package action;

public class DuckEat implements MakeEatingAction {
    @Override
    public void doAction() {
        makeEatingAction();
    }

    @Override
    public void makeEatingAction() {
        System.out.println("Duck is eating.");
    }
}
