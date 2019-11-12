import Farm.Farm;
import Livings.Animals.Animal;
import mediator.AnimalMediator;
import mediator.Mediator;
import mediator.PlantMediator;
import Farm.Menu;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import static org.junit.Assert.*;

/**
 * @program: crazyfarm->MediatorOtherTest
 * @description:
 * @create: 2019-11-12 13:37
 **/

public class MediatorOtherTest {

    private Farm farm;
    private AnimalMediator animalMediator;
    private PlantMediator plantMediator;
    private Menu<Animal> animalMenu;

    @Before
    public void init(){
        //初始化农场和中介者
        farm = Farm.getInstance();
        animalMediator = new AnimalMediator();
        plantMediator = new PlantMediator();

        //初始化动物列表
        Menu<Animal> animalMenu = farm.getAnimalMenu();

        //设置中介者
        farm.setMediatorForFarm(animalMediator, plantMediator);
        farm.addMediatorForAll();
        animalMediator.setFarm(farm);
        plantMediator.setFarm(farm);
    }

    @Test
    public void test(){
        System.out.println("======== 测试 Mediator 模式 ========");

        animalMenu = farm.getAnimalMenu();
        for(int time = 104; time <= 112; time++)
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
