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
        System.out.println("你初始化了一个CropConverter（转换器 Converter模式）");
    }

    public static void main(){
        System.out.println("======== 使用 转换器 Converter模式 =======");
        Crop crop = new Crop();
        CropStateMemento memento = CropStateMemento.getMemento(crop);

        CropConverter converter = new CropConverter();
        assert converter.convertFromDto(memento).equals(crop);
    }
}
