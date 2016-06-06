package highcharts.guidelines;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 06/06/2016.
 */
public class HCVariable  extends HCElement{

    private List<HCWidget> usedByWidgets;
    private List<HCFunction> usedByFunctions;

    public HCVariable(String name, String code) {
        super(name, code);
        usedByWidgets = new ArrayList<>();
        usedByFunctions = new ArrayList<>();
    }

    public List<HCWidget> getUsedByWidgets() {
        return usedByWidgets;
    }

    public void addUsedByWidget(HCWidget w){
        this.usedByWidgets.add(w);
    }

    public List<HCFunction> getUsedByFunctions() {
        return usedByFunctions;
    }

    public void addUsedByFunction(HCFunction f){
        this.usedByFunctions.add(f);
    }
}
