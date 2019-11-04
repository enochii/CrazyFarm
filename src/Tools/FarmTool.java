package Tools;

import Constant.Const;

/**
 * 桥接(Bridge)模式
 * 实现不同规模的不同农具
 * 农具类
 */
public abstract class FarmTool extends Tool {
	
	/**
	 * 农具的Size
	 */
	protected Size size;
	protected Const.Material _material;
	
	public FarmTool(Size s) {
		System.out.println("======== 使用桥接 Bridge 模式 ========");
		this.size = s;
		System.out.print("成功创建");
		if (s.isBig()) {
			System.out.print("大");
		} else {
			System.out.print("小");
		}
	}
	
	/**
	 * 农具的类型
	 */
	public static enum TYPE {
		Hoe, Shovel
	}
	
	/**
	 * @return 农具的类型
	 */
	public abstract TYPE getType();

	/**
	 * do what the farm tool should do
	 */
	public abstract void doWork();

	/**
	 * for the test
	 * @return 返回农具做的工作量
	 */
	public int doWorkTest() {
		if (size.isBig()) {
			return 2;
		} else {
			return 1;
		}
	}

	public abstract void testAbstractFactory();
	
}
