package Tools.Extension;

import Tools.BigSize;
import Tools.Hoe;

public class AugmentedHoe implements HoeExtension {

    private Hoe _hoe;

    public AugmentedHoe() {
        this._hoe = new Hoe(new BigSize());
    }

    @Override
    public void doMoreWork() {
        _hoe.doWork();
        _hoe.doWork();
    }
}
