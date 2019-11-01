package Land;

public class Field extends Land {
    String _usage;

    public Field() { _usage=""; }
    public Field(String usage) {
        this._usage = usage;
    }

    public String getUsage() { return _usage; }

    @Override
    public void use() {
        System.out.println("This field is used.");
    }
}
