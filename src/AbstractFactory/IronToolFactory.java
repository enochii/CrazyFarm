package AbstractFactory;

import Tools.*;
import Tools.StainlessFarmTool.StainlessHoe;
import Tools.StainlessFarmTool.StainlessShovel;

/**
 * 铁制农具工厂
 *
 * @className: IronToolFactory
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 7 :22 下午 2019/10/27
 */
public class IronToolFactory extends AbstractToolFactory {
    private Hoe _smallHoe;
    private Hoe _bigHoe;
    private Shovel _smallShovel;
    private Shovel _bigShovel;

    /**
     * Instantiates a new Iron tool factory.
     */
    public IronToolFactory() {
        this._smallHoe = null;
        this._bigHoe = null;
        this._smallShovel = null;
        this._bigHoe = null;
    }

    public FarmTool createSmallHoe() {
        if (this._smallHoe == null) {
            this._smallHoe = new Hoe(new SmallSize());
        }
        return this._smallHoe;
    }
    public FarmTool createBigHoe() {
        if (this._bigHoe == null) {
            this._bigHoe = new Hoe(new BigSize());
        }
        return this._bigHoe;
    }
    public FarmTool createSmallShovel() {
        if (this._smallShovel == null) {
            this._smallShovel =  new Shovel(new SmallSize());
        }
        return this._smallShovel;
    }
    public FarmTool createBigShovel() {
        if (this._bigShovel == null) {
            this._bigShovel = new Shovel(new BigSize());
        }
        return this._bigShovel;
    }
}
