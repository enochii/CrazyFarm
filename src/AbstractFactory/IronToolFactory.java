package AbstractFactory;

import Tools.*;

/**
 * @className: IronToolFactory
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 7:22 下午 2019/10/27
 */
public class IronToolFactory extends AbstractToolFactory {
    public FarmTool createSmallHoe() {
        return new Hoe(new SmallSize());
    }
    public FarmTool createBigHoe() {
        return new Hoe(new BigSize());
    }
    public FarmTool createSmallShovel() {
        return new Shovel(new SmallSize());
    }
    public FarmTool createBigShovel() {
        return new Shovel(new BigSize());
    }
}
