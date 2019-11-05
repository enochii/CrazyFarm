package Builder;

import Constant.Const;

/**
 * 空闲型农民的 Builder
 *
 * @className: FreeFarmerBuilder
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 6:03 下午 2019/10/27
 */
public class FreeFarmerBuilder extends FarmerBuilder{
    public FreeFarmerBuilder() {
        System.out.println("成功创建空闲型农民Builder");
    }
    public void setWorkType() {
        this._farmer.setType(Const.WorkType.SPARE);
    }
    public void assignTools() {
        // 不分配任何工具
    }
}
