import Adapter.ChickenAdapter;
import Farm.Menu;
import Interpreter.Parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import junit.framework.JUnit4TestAdapter;

import java.util.Observable;
import java.util.Observer;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ChickenAdapter.main();
        Menu.main();
        Parser.main();

    }
}
