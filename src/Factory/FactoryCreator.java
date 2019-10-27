package Factory;

import Constant.Const;

/**
 * @className: FactoryCreator
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 3:09 下午 2019/10/27
 */
public class FactoryCreator {
    /**
     * Gets factory.
     *
     * @param factory_type the factory type
     * @return the factory
     */
    public AbstractFactory getFactory(String factory_type) {
        if (factory_type.equalsIgnoreCase(Const.TYPE_TOOL)) {
            return new ToolFactory();
        }
        else if (factory_type.equalsIgnoreCase(Const.TYPE_LAND)) {
            return new FarmlandFactory();
        }
        return null;
    }
}
