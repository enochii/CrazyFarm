package Factory;

import Land.Land;
import Land.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: FieldFactory
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 8:24 下午 2019/10/27
 */
public class FieldFactory extends Factory{
    private List _usages = new ArrayList();

    @Override
    protected Land createLand(String usage) {
        return new Field(usage);
    }

    @Override
    protected void registerLand(Land land) {
        _usages.add( ((Field)land).getUsage() );
    }

    public List getUsages() {
        return _usages;
    }
}
