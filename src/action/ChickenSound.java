package action;

/**
 * 鸡发声动作
 */
public class ChickenSound implements MakeSoundAction{
    @Override
    public void doAction() {
        makeSoundAction();
    }

    @Override
    public void makeSoundAction() {
        System.out.println("Ji Ji Ji! It's chicken.");
    }
}
