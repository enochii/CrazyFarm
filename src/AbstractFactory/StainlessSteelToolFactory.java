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
    private StainlessHoe _smallHoe;
    private StainlessHoe _bigHoe;
    private StainlessShovel _smallShovel;
    private StainlessShovel _bigShovel;

    public StainlessSteelToolFactory() {
        this._smallHoe = null;
        this._bigHoe = null;
        this._smallShovel = null;
        this._bigHoe = null;
    }

    public FarmTool createSmallHoe() {
        if (this._smallHoe == null) {
            this._smallHoe = new StainlessHoe(new SmallSize());
        }
        return this._smallHoe;
    }
    public FarmTool createBigHoe() {
        if (this._bigHoe == null) {
            this._bigHoe = new StainlessHoe(new BigSize());
        }
        return this._bigHoe;
    }
    public FarmTool createSmallShovel() {
        if (this._smallShovel == null) {
            this._smallShovel = new StainlessShovel(new SmallSize());
        }
        return _smallShovel;
    }
    public FarmTool createBigShovel() {
        if ( this._bigShovel == null ) {
            this._bigShovel = new StainlessShovel(new BigSize());
        }
        return this._bigShovel;
    }
}
