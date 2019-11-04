package Builder;

import AbstractFactory.AbstractToolFactory;
import AbstractFactory.IronToolFactory;
import Constant.Const;
import Tools.BigSize;
import Tools.FarmTool;
import Tools.Hoe;
import Tools.SmallSize;

/**
 * 耕种型农民的 Builder
 *
 * @className: CultivateFarmerBuilder
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 6:08 下午 2019/10/27
 */
public class CultivateFarmerBuilder extends FarmerBuilder {
    public void setWorkType() {
        this._farmer.setType(Const.WorkType.CULTIVATE);
    }
    public void assignTools() {
        // 利用 抽象工厂模式 和 享元模式 获取农具
        AbstractToolFactory ironToolFactory = new IronToolFactory();
        FarmTool ironBigHoe = ironToolFactory.createBigHoe();
        FarmTool ironSmallHoe = ironToolFactory.createSmallHoe();

        this._farmer.assignTool(ironBigHoe);
        this._farmer.assignTool(ironSmallHoe);
    }
}
