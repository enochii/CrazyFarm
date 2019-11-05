package action;

/**
 * 鸭发声动作
 */
public class DuckSound implements MakeSoundAction {
    @Override
    public void doAction() {
        makeSoundAction();
    }

    @Override
    public void makeSoundAction() {
        System.out.println("Ga Ga Ga! It's duck.");
    }
}
