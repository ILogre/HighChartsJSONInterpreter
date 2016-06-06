package highcharts.guidelines;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 06/06/2016.
 */
public class HCFunction extends HCElement{

    private List<HCVariable> usedVariables;
    private List<HCWidget> usedByWidgets;

    public HCFunction(String name, String code) {
        super(name, code);
        usedVariables = new ArrayList<>();
        usedByWidgets = new ArrayList<>();
    }

    public List<HCVariable> getUsedVariables() {
        return usedVariables;
    }

    public void addUsedVariable(HCVariable v){
        this.usedVariables.add(v);
        v.addUsedByFunction(this);
    }

    public List<HCWidget> getUsedByWidgets() {
        return usedByWidgets;
    }

    public void addUsedByWidget(HCWidget w){
        this.usedByWidgets.add(w);
    }
}
