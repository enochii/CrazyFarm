package Memento;

import Livings.Plants.Crop;
import State.State;

/**
 * 作物状态的备忘录
 */
public class CropStateMemento {
    private State _state;
    private boolean _isMature;
    private int _experience = 0;

    /**
     *
     * @param crop 需要备份的作物
     *             构造函数
     */
    private CropStateMemento(Crop crop){
        this._experience  = crop._experience;
        this._isMature = crop._isMature;
        this._state = crop._state;
    }

    /**
     *
     * @param crop 需要备份的作物
     * @return 备份的作物当前的状态
     */
    public static CropStateMemento getMemento(Crop crop){
        System.out.println("你正在获取Crop的状态（备忘录 Memento模式）");
        return new CropStateMemento(crop);
    }

    /**
     *
     * @param crop 需要回退到某个状态的作物
     * @param state 用户希望的回退后的状态
     */
    public static void setMemento(Crop crop, CropStateMemento state){
        crop._state = state._state;
        crop._experience = state._experience;
        crop._isMature = state._isMature;
        System.out.println("你已经成功将Crop回退到对应的状态（备忘录 Memento模式）");
    }

    @Override
    public boolean equals(Object o){
        CropStateMemento memento = null;
        try{
            memento = (CropStateMemento) o;
        }catch (ClassCastException e){
            System.out.println("Class Cast Error");
        }
        return this._isMature == memento._isMature &&
                this._experience == memento._experience &&
                this._state == memento._state;
    }

    public static void main(){
        System.out.println("======== 使用 备忘录 Memento模式 =======");
        Crop crop = new Crop();
        Crop cropCopy = crop.clone();

        CropStateMemento state = CropStateMemento.getMemento(crop);
        //改变作物的状态
        crop.changeCropState();
        System.out.println("改变状态后crop的状态如下");
        crop.printCrop();
        CropStateMemento.setMemento(crop, state);
        System.out.println("回退状态后crop的状态如下");
        crop.printCrop();
    }
}
