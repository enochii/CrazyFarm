package Interpreter;

public class AddExpression implements Expression {
    //TODO : 延时+记忆化

    //左、右子节点
    private Expression _left, _right;

    /*
     * AddExpression 构造函数
     */
    AddExpression(Expression left, Expression right){
        this._left = left;
        this._right = right;
    }

    /*
     * @return 返回加法表达式的价值
     */
    @Override
    public double interpret(){
        return _left.interpret() + _right.interpret();
    }
}
