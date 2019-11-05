/*
 * Command接口，用于实现各类命令
*/


package Command;

/**
 * The interface Command.
 */
public interface Command {

    /**
     * 命令的执行函数
     */
    public abstract void execute();
}
