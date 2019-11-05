package Factory;

import Land.Land;
import Land.Field;
import Land.LargeField;

/**
 * 土地工厂，是一个抽象基类。
 *
 * @className: Factory
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 8 :20 下午 2019/10/27
 */
public abstract class Factory {
    /**
     * Create land.
     * 创建土地并在工厂中进行注册。
     *
     * @param usage the usage
     * @return the land
     */
    public final Land create(String usage) {
        Land land = createLand(usage);
        registerLand(land);
        return land;
    }

    /**
     * Create land.
     * 抽象方法：创建一块土地并说明这块土地的用途
     *
     * @param usage the usage
     * @return the land
     */
    protected abstract Land createLand(String usage);

    /**
     * Register land.
     * 抽象方法：在工厂中对土地进行注册
     *
     * @param land the land
     */
    protected abstract void registerLand(Land land);
}

/**
 * The type Test factory.
 */
class TestFactory {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println("测试小块土地工厂：");
        Factory fieldFactory = new FieldFactory();
        Field field1 = (Field) fieldFactory.create("growing corn");
        System.out.println("Create a field for " + field1.getUsage() + ".");
        field1.use();
        Field field2 = (Field) fieldFactory.create("growing potato");
        System.out.println("Create a field for " + field2.getUsage() + ".");
        field2.use();

        System.out.println("测试大片土地工厂：");
        Factory largeFieldFactory = new LargeFieldFactory();
        LargeField largeField1 = (LargeField) largeFieldFactory.create("raising ducks");
        System.out.println("Create a large field for " + largeField1.getUsage() + ".");
        largeField1.use();
        LargeField largeField2 = (LargeField) largeFieldFactory.create("raising chickens");
        System.out.println("Create a large field for " + largeField2.getUsage() + ".");
        largeField2.use();
    }
}
