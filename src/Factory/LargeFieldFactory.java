package Factory;

import Land.Land;
import Land.LargeField;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: LargeFieldFactory
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 8:24 下午 2019/10/27
 */
public class LargeFieldFactory extends Factory{
    private List _usages = new ArrayList();

    @Override
    protected Land createLand(String usage) {
        return new LargeField(usage);
    }

    @Override
    protected void registerLand(Land land) {
        _usages.add( ((LargeField)land).getUsage() );
    }

    public List getUsages() {
        return _usages;
    }
}
