package SolveStarvation;

import Farm.Farm;

/**
 * 责任链(chain of responsibility)模式
 */
public abstract class SolveStarvation {
    private SolveStarvation _next;
    private String _name;
    public Farm _farm;

    /**
     * 构造函数
     * @param name 解决问题的人的名字
     * @param farm 解决的问题的农场
     */
    public SolveStarvation(String name, Farm farm){
        _name = name;
        _farm = farm;
    }

    /**
     * 确定下一级负责的角色
     * @param solveStarvation 下一级负责的类
     * @return 下一级负责的角色
     */
    public SolveStarvation setNext(SolveStarvation solveStarvation){
        this._next = solveStarvation;
        return solveStarvation;
    }

    @Override
    public String toString(){
        return this._name;
    }

    /**
     * 不同角色有不同的解决办法
     * @param starvation 具体需要解决的问题
     * @return 是否解决
     */
    protected abstract boolean resolve(Starvation starvation);

    /**
     * 喂食成功
     * @param starvation 具体需要解决的问题
     */
    protected void finish(Starvation starvation){
        System.out.println(starvation + " It is solved by " + this);
        _farm.getAnimalMediator().getStarvedAnimals().clear();
    }

    /**
     * 喂食失败
     * @param starvation 具体需要解决的问题
     */
    protected void fail(Starvation starvation){
        System.out.println(starvation + "solving has been failed.");
    }

    /**
     * 尝试解决动物饥饿的问题，并根据解决的结果调用相应函数表明成功解决和解决失败
     * @param starvation 具体需要解决的问题
     */
    public final void solve(Starvation starvation){
        System.out.println("======== 使用责任链 Chain of Responsibilities 模式 =========");
        if(resolve(starvation)){
            finish(starvation);
        }else if (_next !=null){
            _next.solve(starvation);
        }else{
            fail(starvation);
        }
    }
}
