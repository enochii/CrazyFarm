package Converter;

import Livings.Plants.Crop;
import Memento.CropStateMemento;

import java.util.function.Function;

/**
 * @author : SCH001
 * @description : converter，实现dto（Data Transfer Object）对象和entity（实体）对象的转换
 */
public class Converter<T, U> {

    private final Function<T, U> _fromDto;
    private final Function<U, T> _fromEntity;

    /**
     * @param fromDto    函数对象，将dto转换为实体
     * @param fromEntity 函数对象，将实体转换为dto
     */
    public Converter(final Function<T, U> fromDto, final Function<U, T> fromEntity) {
        this._fromDto = fromDto;
        this._fromEntity = fromEntity;
    }

    /**
     * @param dto 待转换的DTO
     * @return 转换后的实体对象
     */
    public final U convertFromDto(final T dto) {
        System.out.println("你正在从对应dto恢复实体（转换器 Converter模式）");
        return _fromDto.apply(dto);
    }

    /**
     * @param entity 带转换的实体
     * @return 转换后的dto
     */
    public final T convertFromEntity(final U entity) {
        System.out.println("你正在从对应的实体生成相应的dto（转换器 Converter模式）");
        return _fromEntity.apply(entity);
    }

    public static void main(){
        System.out.println("=======使用 转换器 Converter模式");
        Crop crop = new Crop();
        System.out.println("待转换的crop状态如下");
        crop.printCrop();
        System.out.println("你使用了转换器模式获得了一个dto");
        CropConverter converter = new CropConverter();
        CropStateMemento stateMemento = converter.convertFromEntity(crop);
        System.out.println("你使用转换器将dto转成了一个新的crop");
        System.out.println("它的状态如下");
        Crop converted = converter.convertFromDto(stateMemento);
        converted.printCrop();
    }
}
