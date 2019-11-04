import Farm.Farm;
import mediator.AnimalMediator;
import mediator.PlantMediator;
import org.junit.Test;

/**
 * @program: crazyfarm->MediatorTest
 * @description: 中介者模式的测试类
 * @author: jh
 * @create: 2019-11-04 16:42
 **/

public class MediatorTest {

    @Test
    public void test(){

        Farm farm = Farm.getInstance();

        AnimalMediator animalMediator = new AnimalMediator();
        PlantMediator plantMediator = new PlantMediator();

        farm.setMediatorForFarm(animalMediator, plantMediator);
        farm.addMediatorForAll();

        animalMediator.setFarm(farm);
        plantMediator.setFarm(farm);
    }
}
