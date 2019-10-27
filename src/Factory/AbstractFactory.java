package Factory;

import Land.Land;
import Tools.Tool;

public abstract class AbstractFactory {
    /**
     * Gets tool.
     *
     * @param tool_type the tool type
     * @return the tool
     */
    public abstract Tool getTool(String tool_type);

    /**
     * Gets land.
     *
     * @param land_type the land type
     * @return the land
     */
    public abstract Land getLand(String land_type);
}
