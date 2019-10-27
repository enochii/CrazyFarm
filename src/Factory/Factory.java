package Factory;

import Land.Land;

/**
 * @className: Factory
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 8:20 下午 2019/10/27
 */
public abstract class Factory {
    public final Land create(String usage) {
        Land land = createLand(usage);
        registerLand(land);
        return land;
    }

    protected abstract Land createLand(String usage);
    protected abstract void registerLand(Land land);
}

class TestFactory {
    public static void main(String[] args) {
        System.out.println("测试小块土地工厂：");
        Factory fieldFactory = new FieldFactory();
        Land field1 = fieldFactory.create("growing corn");
        System.out.println("Create a field for " + field1.getUsage() + ".");
        Land field2 = fieldFactory.create("growing potato");
        System.out.println("Create a field for " + field2.getUsage() + ".");

        System.out.println("测试大片土地工厂：");
        Factory largeFieldFactory = new LargeFieldFactory();
        Land largeField1 = largeFieldFactory.create("raising ducks");
        System.out.println("Create a large field for " + largeField1.getUsage() + ".");
        Land largeField2 = largeFieldFactory.create("raising chickens");
        System.out.println("Create a large field for " + largeField2.getUsage() + ".");
    }
}
