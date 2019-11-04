package Builder;

import AbstractFactory.AbstractToolFactory;
import AbstractFactory.IronToolFactory;
import Constant.Const;
import Tools.BigSize;
import Tools.FarmTool;
import Tools.Shovel;
import Tools.SmallSize;

/**
 * @className: FeedFarmerBuilder
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 6:08 下午 2019/10/27
 */
public class FeedFarmerBuilder extends FarmerBuilder {
    public void setWorkType() {
        this._farmer.setType(Const.WorkType.FEED);
    }
    public void assignTools() {
        // 利用 抽象工厂模式 和 享元模式 获取农具
        AbstractToolFactory ironToolFactory = new IronToolFactory();
        FarmTool ironBigShovel = ironToolFactory.createBigShovel();
        FarmTool ironSmallShovel = ironToolFactory.createSmallShovel();

        this._farmer.assignTool( ironBigShovel );
        this._farmer.assignTool( ironSmallShovel );
    }
}
