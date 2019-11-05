import Farm.Farm;
import Livings.Animals.Animal;
import mediator.AnimalMediator;
import mediator.Mediator;
import mediator.PlantMediator;
import org.junit.Test;
import Farm.Menu;
import java.util.Iterator;

/**
 * @program: crazyfarm->MediatorTest
 * @description: 中介者模式的测试类
 * @author: jh
 * @create: 2019-11-04 16:42
 **/

public class MediatorTest {

    @Test
    public void test(){

        System.out.println("======== 测试 MVC 模式 ========");
        Farm farm = Farm.getInstance();
        AnimalMediator animalMediator = new AnimalMediator();
        PlantMediator plantMediator = new PlantMediator();
        farm.setMediatorForFarm(animalMediator, plantMediator);
        System.out.println("classname: (farm) : addMediatorForAll: setMediator for all animals in farm");
        farm.addMediatorForAll();

        System.out.println("classname: (animalMediator) : setFarm: make the global farm's animal be animalMediator's colleagues ");
        animalMediator.setFarm(farm);
        System.out.println("classname: (plantMediator) : setFarm: make the global farm's plant be plantMediator's colleagues ");
        plantMediator.setFarm(farm);
        Menu<Animal> animalMenu = farm.getAnimalMenu();

        for(int time = 98; time <= 110; time++)
        {
            for (Iterator<Animal> it = animalMenu.iterator(); it.hasNext();){
                Animal animal=it.next();
                System.out.println("animal:" + animal.getName() +"上次喂食时间: " + animal._lastFedTime);
                System.out.println("classname: (animal) :setClock: set time for animals, if they are hungry, they will eat, if not, they will gain maturityRate");
                animal.setClock(time);
            }
            Mediator mediator=farm.getAnimalMediator();

            System.out.println("classname: (mediator) :colleagueChanged: check hungry animals, and add food to foodcourt");
            mediator.colleagueChanged();

        }
    }
}
