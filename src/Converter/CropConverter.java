package Converter;

import Livings.Plants.Crop;
import Memento.CropStateMemento;

/**
 * @author : SCH001
 * @description :
 */
public class CropConverter extends Converter<CropStateMemento, Crop> {

    public CropConverter(){
        super(cropState->{
            Crop crop = new Crop();
            CropStateMemento.setMemento(crop,cropState);
            return crop;
        }, CropStateMemento::getMemento);
    }
}
