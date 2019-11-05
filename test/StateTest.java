import Livings.Animals.Animal;
import Livings.Animals.Chicken.TableChicken;
import mediator.AnimalMediator;
import org.junit.Test;

/**
 * @program: crazyfarm->StateTest
 * @description: 状态模式的测试类
 * @author: jh
 * @create: 2019-11-04 21:00
 **/

public class StateTest {

    @Test
    public void test(){
        System.out.println("======== 测试 State 模式 ========");

        TableChicken tableChicken = new TableChicken();


        System.out.println("TableChicken : " + tableChicken.hashCode() +  " : setClock : update the time of tableChicken");
        tableChicken.setClock(5);
        System.out.println("tableChicken is hungry? " + tableChicken.isHungry());

        System.out.println("TableChicken : " + tableChicken.hashCode() +  " : setClock : update the time of tableChicken");
        tableChicken.setClock(7);
        System.out.println("tableChicken is hungry? " + tableChicken.isHungry());

        System.out.println("TableChicken : " + tableChicken.hashCode() +  " : setClock : update the time of tableChicken");
        tableChicken.getFed(7);
        System.out.println("tableChicken is hungry? " + tableChicken.isHungry());
    }
}
