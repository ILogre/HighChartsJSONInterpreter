package PivotModel;

/**
 * Created by ivan on 25/04/2016.
 */
public abstract class NamedElement {
    private String name;

    public NamedElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
