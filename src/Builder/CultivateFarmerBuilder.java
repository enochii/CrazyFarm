package Builder;

import Constant.Const;
import Tools.BigSize;
import Tools.Hoe;
import Tools.SmallSize;

/**
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
        this._farmer.assignTool(new Hoe(new BigSize()));
        this._farmer.assignTool(new Hoe(new SmallSize()));
    }
}
