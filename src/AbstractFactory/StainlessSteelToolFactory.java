package AbstractFactory;

import Tools.BigSize;
import Tools.FarmTool;
import Tools.SmallSize;
import Tools.StainlessFarmTool.StainlessHoe;
import Tools.StainlessFarmTool.StainlessShovel;

/**
 * 不锈钢制农具工厂
 *
 * @className: StainlessSteelToolFactory
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 7 :23 下午 2019/10/27
 */
public class StainlessSteelToolFactory extends AbstractToolFactory {
    /**
     * 4个私有成员保存对应的农具对象，用于实现享元模式
     */
    private StainlessHoe _smallHoe;
    private StainlessHoe _bigHoe;
    private StainlessShovel _smallShovel;
    private StainlessShovel _bigShovel;

    /**
     * Instantiates a new Stainless steel tool factory.
     */
    public StainlessSteelToolFactory() {
        this._smallHoe = null;
        this._bigHoe = null;
        this._smallShovel = null;
        this._bigHoe = null;
    }

    /**
     * 按照享元模式创建不锈钢制小锄头
     */
    public FarmTool createSmallHoe() {
        if (this._smallHoe == null) {
            this._smallHoe = new StainlessHoe(new SmallSize());
        }
        return this._smallHoe;
    }
    /**
     * 按照享元模式创建不锈钢制大锄头
     */
    public FarmTool createBigHoe() {
        if (this._bigHoe == null) {
            this._bigHoe = new StainlessHoe(new BigSize());
        }
        return this._bigHoe;
    }
    /**
     * 按照享元模式创建不锈钢制小铲子
     */
    public FarmTool createSmallShovel() {
        if (this._smallShovel == null) {
            this._smallShovel = new StainlessShovel(new SmallSize());
        }
        return _smallShovel;
    }
    /**
     * 按照享元模式创建不锈钢制大铲子
     */
    public FarmTool createBigShovel() {
        if ( this._bigShovel == null ) {
            this._bigShovel = new StainlessShovel(new BigSize());
        }
        return this._bigShovel;
    }
}
