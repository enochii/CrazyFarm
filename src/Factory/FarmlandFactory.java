package Factory;

import Constant.Const;
import Land.Field;
import Land.Land;
import Land.LargeField;
import Tools.Tool;

public class FarmlandFactory extends AbstractFactory{
    public Field _field;
    public LargeField _large_field;

    public FarmlandFactory() {
        this._field = null;
        this._large_field = null;
    }

    public Tool getTool(String tool_type) {
        return null;
    }

    public Land getLand(String land_type) {
        if (land_type == null) {
            return null;
        }
        else if ( land_type.equalsIgnoreCase(Const.TYPE_FIELD) ) {
            if (this._field == null) {
                this._field = new Field();
            }
            return this._field;
        }
        else if (land_type.equalsIgnoreCase(Const.TYPE_LARGE_FIELD) ) {
            if (this._large_field == null) {
                this._large_field = new LargeField();
            }
            return this._large_field;
        }
        return null;
    }
}
