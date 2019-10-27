package Builder;

import Constant.Const;
import Tools.BigSize;
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
        // 暂时没按照享元模式，后面更改
        this._farmer.assignTool( new Shovel(new BigSize()));
        this._farmer.assignTool( new Shovel(new SmallSize()));
    }
}
