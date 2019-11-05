package criteria;

import Livings.Animals.Animal;

import java.util.List;

/**
 * 过滤标准
 */
public interface Criteria {
    /**
     * 按照标准过滤输入动物得到输出动物列表
     * @param animals 等待被过滤的动物列表
     * @return 返回过滤完成得到的动物列表
     */
    List<Animal> meetCriteria(List<Animal> animals);
}
