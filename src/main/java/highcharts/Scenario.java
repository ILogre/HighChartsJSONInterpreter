package highcharts;

import PivotModel.Dashboard;
import exception.FMEngineException;
import exceptions.FileIsNotAccessible;
import fr.familiar.interpreter.VariableNotExistingException;
import fr.familiar.parser.VariableAmbigousConflictException;
import highcharts.HighChartsInterpretor;
import highcharts.HighChartsJSONExtractor;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by ivan on 25/04/2016.
 */
public class Scenario {

    public static final String PATH_TO_ROOT_FOLDER = "resources/";
    public static final String DASHBOARD = "interaction_bar_pie_stacked";
    public static final String VIEW = "Rainfall_Analysis";
    public static void main(String [] args){
        try {
            Map<String,JSONObject> visualizations = HighChartsJSONExtractor.extract(new File(PATH_TO_ROOT_FOLDER+DASHBOARD+".htm"));
            Dashboard dash = HighChartsInterpretor.interprete(visualizations);
        } catch (FileIsNotAccessible fileIsNotAccessible) {
            fileIsNotAccessible.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (VariableNotExistingException e) {
            e.printStackTrace();
        } catch (VariableAmbigousConflictException e) {
            e.printStackTrace();
        } catch (FMEngineException e) {
            e.printStackTrace();
        }
    }
}
