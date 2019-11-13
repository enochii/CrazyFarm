import BusinessDelegate.BusinessDelegate;
import Constant.Const;
import Farm.Menu;
import Livings.Animals.Animal;
import Livings.Plants.Plant;
import Visitor.ExpLivingVisitor;
import org.junit.*;
import Farm.*;

import java.util.Iterator;

/**
 * @className: VisitorOtherTest
 * @description:
 * @designPattern:
 * @date: 2019/11/12 21:44
 */
public class VisitorOtherTest {
    private ExpLivingVisitor expLivingVisitor;
    private Menu<Plant> plantmenu;
    private  Menu<Animal> animalmenu;
    private Farm farm;
    @Before
    public void setUp() {
        System.out.println("======== 测试 Visitor 模式 ========");
        farm=Farm.getInstance();
        animalmenu=farm.getAnimalMenu();
        plantmenu=farm.getPlantMenu();
        expLivingVisitor = new ExpLivingVisitor();

    }

    @Test
    public void testForVisitor() {
        System.out.println("测试生物经验值访问者：");
        System.out.println("\n测试动物经验访问者：");
        for(Iterator<Animal> it = animalmenu.iterator(); it.hasNext(); ){
            Animal animal=it.next();
            animal.accept(expLivingVisitor);
        }
        System.out.println("\n测试植物经验访问者：");
        for(Iterator<Plant>it=plantmenu.iterator();it.hasNext(); ){
            Plant plant=it.next();
            plant.accept(expLivingVisitor);
        }
    }
}
