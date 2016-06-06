package highcharts.guidelines;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by ivan on 06/06/2016.
 */
public class HCWidget  extends HCElement{

    public static final String BEGIN_DETECT_WIDGET = "$('#";
    public static final String END_DETECT_WIDGET = "').highcharts(";

    private List<HCVariable> usedVariables;
    private List<HCFunction> usedFunctions;
    private JSONObject code;

    public HCWidget(String name, String code) {
        super(name, code);
        this.code = new JSONObject(code);
    }

    public JSONObject getJSONCode() {
        return code;
    }

    public List<HCVariable> getUsedVariables() {
        return usedVariables;
    }

    public void addUsedVariable(HCVariable v){
        this.usedVariables.add(v);
        v.addUsedByWidget(this);
    }

    public List<HCFunction> getUsedFunctions() {
        return usedFunctions;
    }

    public void addUsedFunction(HCFunction f){
        this.usedFunctions.add(f);
        f.addUsedByWidget(this);
    }
}
