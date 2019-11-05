package Tools.StainlessFarmTool;

import Constant.Const;
import Tools.FarmTool;
import Tools.Size;

/**
 * @className: StainlessHoe
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 7:35 下午 2019/10/27
 */
public class StainlessHoe extends FarmTool {

    public StainlessHoe(Size s) {
        super(s);
        this._material = Const.Material.STAINLESS_STEEL;
        System.out.println("锄头");
    }

    @Override
    public TYPE getType() {
        return TYPE.Hoe;
    }

    @Override
    public void doWork() {

    }

    public void testAbstractFactory() {
        String s_size = this.size.isBig()? "big" : "small";
        System.out.println("Create " + s_size + " stainless steel hoe successfully.");
    }

}
