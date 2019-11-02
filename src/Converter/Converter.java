package Converter;

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
        return _fromDto.apply(dto);
    }

    /**
     * @param entity 带转换的实体
     * @return 转换后的dto
     */
    public final T convertFromEntity(final U entity) {
        return _fromEntity.apply(entity);
    }

}
