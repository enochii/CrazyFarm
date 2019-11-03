package Tools;

import java.io.Serializable;

/**
 * Size接口
 */
public interface Size extends Serializable {
	
	/**
	 * @return Size的大小
	 */
	public int getSize();

	public boolean isBig();

	public boolean isSmall();
}
