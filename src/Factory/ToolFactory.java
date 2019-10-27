package Factory;

import Constant.Const;
import Land.Land;
import Tools.BigSize;
import Tools.Hoe;
import Tools.Shovel;
import Tools.Tool;

public class ToolFactory extends AbstractFactory {
    public Tool _hoe;
    public Tool _shovel;

    public ToolFactory() {
        this._hoe = null;
        this._shovel = null;
    }

    public Land getLand(String land_type) {
        return null;
    }

    public Tool getTool(String tool_type) {
        if (tool_type == null) {
            return null;
        }
        else if (tool_type.equalsIgnoreCase(Const.TYPE_HOE) ) {
            if (this._hoe == null) {
                // size用于实现桥接模式，这里默认采用 big size
                this._hoe = new Hoe(new BigSize());
            }
            return this._hoe;

        }
        else if ( tool_type.equalsIgnoreCase(Const.TYPE_SHOVEL) ) {
            if (this._shovel == null) {
                this._shovel = new Shovel(new BigSize());
            }
            return this._shovel;
        }
        return null;
    }
}
