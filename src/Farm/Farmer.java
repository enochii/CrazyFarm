package Farm;

/*
 * 农民，完成各种农场的工作
 */

public class Farmer {

    //农民的工作状态
    private boolean isWorking;
    //TODO: 加上具体的Task
    public void doWork(){
        System.out.println("Implement  me!");
    }

    /**
     * Get work status boolean.
     *
     * @return the boolean
     */
    public boolean getWorkStatus(){
        return this.isWorking;
    }

    public Farmer(){
        this.isWorking = false;
    }

}
