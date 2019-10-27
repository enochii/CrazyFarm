package Builder;

import Constant.Const;

/**
 * @className: FreeFarmerBuilder
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 6:03 下午 2019/10/27
 */
public class FreeFarmerBuilder extends FarmerBuilder{
    public void setWorkType() {
        this._farmer.setType(Const.WorkType.SPARE);
    }
    public void assignTools() {
        // 不分配任何工具
    }
}
