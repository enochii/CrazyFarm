package Factory;

import Land.Land;
import Land.LargeField;

import java.util.ArrayList;
import java.util.List;

/**
 * The Large field factory.
 * 大片土地工厂
 *
 * @className: LargeFieldFactory
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 8 :24 下午 2019/10/27
 */
public class LargeFieldFactory extends Factory{
    private List _usages = new ArrayList();     // 土地用途记录表，统计注册土地的用途

    @Override
    protected Land createLand(String usage) {
        return new LargeField(usage);
    }

    @Override
    protected void registerLand(Land land) {
        _usages.add( ((LargeField)land).getUsage() );
    }

    /**
     * Gets usages.
     * 获取土地用途记录表
     *
     * @return the usages
     */
    public List getUsages() {
        return _usages;
    }
}
