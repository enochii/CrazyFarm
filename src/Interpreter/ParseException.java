package Interpreter;

/**
 * 自定义的解析异常，当发生语法错误会被Parser抛出，用来更快地定位错误
 */
public class ParseException extends Exception {
    public ParseException(String msg){
        super(msg);
    }
}
