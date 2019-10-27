import Constant.Const;
import Interpreter.ParseException;
import Interpreter.Parser;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InterpreterTest {
    @Test
    public void test() throws ParseException {
        double ret = Parser.parse("1 + 2 * 3"+" + "+ Const.VALUE_CROP).interpret();
        assertEquals(ret, 1 + 2 * 3 + Const.VALUE_CROP, 0.0);

        ret = Parser.parse("1 + 2 * 3"+" * "+ Const.VALUE_CROP).interpret();
        assertEquals(ret, 1 + 2 * 3 * Const.VALUE_CROP, 0.0);
    }
}