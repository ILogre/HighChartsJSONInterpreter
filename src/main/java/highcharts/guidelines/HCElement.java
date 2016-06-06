package highcharts.guidelines;

/**
 * Created by ivan on 06/06/2016.
 */
public abstract class HCElement {
    private String name;
    private String code;

    public HCElement(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HCElement hcElement = (HCElement) o;

        return name.equals(hcElement.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
