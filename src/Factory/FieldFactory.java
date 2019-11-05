package Factory;

import Land.Land;
import Land.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * The Field factory.
 * 小块土地工厂
 *
 * @className: FieldFactory
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 8 :24 下午 2019/10/27
 */
public class FieldFactory extends Factory{
    private List _usages = new ArrayList();     // 土地用途记录表，统计注册土地的用途

    public FieldFactory() {
        System.out.println("======== 使用工厂 Factory 模式 ========");
        System.out.println("成功创建小块土地工厂");
    }

    @Override
    protected Land createLand(String usage) {
        return new Field(usage);
    }

    @Override
    protected void registerLand(Land land) {
        _usages.add( ((Field)land).getUsage() );
    }

    /**
     * Gets usages.
     * 获取土地用途记录表
     *
     * @return the usages
     */
    public List getUsages() {
        return _usages;
    }
}
