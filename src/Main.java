import Adapter.ChickenAdapter;
import Farm.Menu;
import Interpreter.Parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import Livings.Animals.Chicken.TableChicken;
import junit.framework.JUnit4TestAdapter;

import java.util.Observable;
import java.util.Observer;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ChickenAdapter.main();
        Menu.main();
        Parser.main();
        TableChicken tableChicken = new TableChicken();
        tableChicken.setClock(6);
        System.out.println(tableChicken.isHungry());
        tableChicken.getFed(6);
        System.out.println(tableChicken.isHungry());
        tableChicken.setClock(7);
        System.out.println(tableChicken.isHungry());
        System.out.println(tableChicken._experience);
        tableChicken.setClock(16);
        System.out.println(tableChicken.isHungry());


    }
}
