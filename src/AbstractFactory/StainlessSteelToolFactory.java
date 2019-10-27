package AbstractFactory;

import Tools.BigSize;
import Tools.FarmTool;
import Tools.SmallSize;
import Tools.StainlessFarmTool.StainlessHoe;
import Tools.StainlessFarmTool.StainlessShovel;

/**
 * @className: StainlessSteelToolFactory
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 7:23 下午 2019/10/27
 */
public class StainlessSteelToolFactory extends AbstractToolFactory {
    public FarmTool createSmallHoe() {
        return new StainlessHoe(new SmallSize());
    }
    public FarmTool createBigHoe() {
        return new StainlessHoe(new BigSize());
    }
    public FarmTool createSmallShovel() {
        return new StainlessShovel(new SmallSize());
    }
    public FarmTool createBigShovel() {
        return new StainlessShovel(new BigSize());
    }
}
