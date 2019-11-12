import Factory.Factory;
import Land.Field;
import Land.LargeField;
import org.junit.Before;
import org.junit.Test;
import Factory.*;

/**
 * @className: FactoryOtherTest
 * @description:
 * @designPattern:
 * @date: 11:58 上午 2019/11/12
 */
public class FactoryOtherTest {

    private Factory fieldFactory;
    private Factory largeFieldFactory;

    @Before
    public void setUp() {
        System.out.println("======== 测试 Factory 模式 ========");
        fieldFactory = new FieldFactory();
        largeFieldFactory = new LargeFieldFactory();
    }

    @Test
    public void testForFactory() {
        System.out.println("\n测试小块土地工厂：");
        Field field1 = (Field) fieldFactory.create("planting apple trees");
        System.out.println("Create a field for " + field1.getUsage() + ".");
        field1.use();
        Field field2 = (Field) fieldFactory.create("Planting onions");
        System.out.println("Create a field for " + field2.getUsage() + ".");
        field2.use();

        System.out.println("\n测试大片土地工厂：");
        LargeField largeField1 = (LargeField) largeFieldFactory.create("raising ducks");
        System.out.println("Create a large field for " + largeField1.getUsage() + ".");
        largeField1.use();
        LargeField largeField2 = (LargeField) largeFieldFactory.create("raising chickens");
        System.out.println("Create a large field for " + largeField2.getUsage() + ".");
        largeField2.use();
    }
}
