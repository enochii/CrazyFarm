package Tools;

import java.io.Serializable;

/**
 * 桥接(Bridge)模式
 * 实现不同规模的不同农具
 * 规模接口
 */
public interface Size extends Serializable {
	
	/**
	 * @return Size的大小
	 */
	public int getSize();

	public boolean isBig();

	public boolean isSmall();
}
