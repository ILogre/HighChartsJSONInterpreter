package highcharts.guidelines;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 06/06/2016.
 */
public class HCDashboard {

    public static final String BEGIN_DASHBOARD = "<script type=\"text/javascript\">";
    public static final String END_DASHBOARD = "</script>";

    private List<HCFunction> functions;
    private List<HCVariable> variables;
    private List<HCWidget> widgets;

    public HCDashboard() {
        functions = new ArrayList<>();
        variables = new ArrayList<>();
        widgets = new ArrayList<>();
    }

    public List<HCFunction> getFunctions() {
        return functions;
    }

    public List<HCVariable> getVariables() {
        return variables;
    }

    public List<HCWidget> getWidgets() {
        return widgets;
    }

    public void addFunction(HCFunction f){
        this.functions.add(f);
    }

    public void addVariable(HCVariable v){
        this.variables.add(v);
    }

    public void addWidget(HCWidget w){
        this.widgets.add(w);
    }

}
