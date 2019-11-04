package Tools.Extension;

import Tools.BigSize;
import Tools.Hoe;

/**
 * 扩展对象(Extension objects)对象
 * 通过扩展大锄头实现加强版锄头
 */
public class AugmentedHoe implements HoeExtension {

    private Hoe _hoe;

    /**
     * 构造函数
     */
    public AugmentedHoe() {
        System.out.println("======== 使用扩展对象 Extension objects 模式 ========");
        System.out.println("成功创建增强锄头");
        this._hoe = new Hoe(new BigSize());
    }

    /**
     * 加强版锄头可以做更多的工作
     */
    @Override
    public void doMoreWork() {
        _hoe.doWork();
        _hoe.doWork();
    }

    /**
     * 加强版锄头工作测试
     */
    public int doMoreWorkTest() {
        return _hoe.doWorkTest()*2;
    }
}
