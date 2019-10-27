package SolveStarvation;

import Farm.Farm;

public abstract class SolveStarvation {
    private SolveStarvation _next;
    private String _name;
    public Farm _farm;

    /**
     * 构造函数
     * @param name
     * @param farm
     */
    public SolveStarvation(String name, Farm farm){
        _name = name;
        _farm = farm;
    }

    /**
     * 确定下一级负责的角色
     * @param solveStarvation
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
     * @param starvation
     * @return 是否解决
     */
    protected abstract boolean resolve(Starvation starvation);

    /**
     * 喂食成功
     * @param starvation
     */
    protected void finish(Starvation starvation){
        System.out.println(starvation + "is solved by" + this);
        _farm.getAnimalMediator().getStarvedAnimals().clear();
    }

    /**
     * 喂食失败
     * @param starvation
     */
    protected void fail(Starvation starvation){
        System.out.println(starvation + "solving has been failed.");
    }

    public final void solve(Starvation starvation){
        if(resolve(starvation)){
            finish(starvation);
        }else if (_next !=null){
            _next.resolve(starvation);
        }else{
            fail(starvation);
        }
    }
}
