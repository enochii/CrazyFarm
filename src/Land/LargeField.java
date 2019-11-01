package Land;

public class LargeField extends Land{
    String _usage;

    public LargeField() { _usage=""; }
    public LargeField(String usage) {
        this._usage = usage;
    }

    public String getUsage() { return _usage; }

    @Override
    public void use() {
        System.out.println("This large field is used.");
    }
}
