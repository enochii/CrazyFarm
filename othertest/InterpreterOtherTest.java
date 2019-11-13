import Constant.Const;
import Interpreter.ParseException;
import Interpreter.Parser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author : SCH001
 * @description :
 */
public class InterpreterOtherTest {
    @Before
    public void setup(){
        System.out.println("======== 测试 Interpreter 模式 ========");
    }

    @Test
    public void test() throws ParseException {
        double ret = Parser.parse("9 + 2 * 3"+" + "+ Const.VALUE_TABLE_CHICKEN).interpret();
        assertEquals(ret, 9 + 2 * 3 + Const.VALUE_TABLE_CHICKEN, 0.0);

        ret = Parser.parse("20 * " + Const.VALUE_TABLE_CHICKEN + " + 3"+" * "+ Const.VALUE_CROP).interpret();
        assertEquals(ret, 20 * Const.VALUE_TABLE_CHICKEN +  3 * Const.VALUE_CROP, 0.0);
    }

}
