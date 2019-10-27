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
    }

}
