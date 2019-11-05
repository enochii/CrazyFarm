package Factory;

import Land.Land;
import Land.Field;
import Land.LargeField;

/**
 * 土地工厂，是一个抽象基类。
 *
 * @className: Factory
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 8 :20 下午 2019/10/27
 */
public abstract class Factory {
    /**
     * Create land.
     * 创建土地并在工厂中进行注册。
     *
     * @param usage the usage
     * @return the land
     */
    public final Land create(String usage) {
        Land land = createLand(usage);
        registerLand(land);
        return land;
    }

    /**
     * Create land.
     * 抽象方法：创建一块土地并说明这块土地的用途
     *
     * @param usage the usage
     * @return the land
     */
    protected abstract Land createLand(String usage);

    /**
     * Register land.
     * 抽象方法：在工厂中对土地进行注册
     *
     * @param land the land
     */
    protected abstract void registerLand(Land land);
}