package highcharts;

import EntryPoint.Shelf;
import PivotModel.*;
import exception.FMEngineException;
import fr.familiar.interpreter.VariableNotExistingException;
import fr.familiar.parser.VariableAmbigousConflictException;
import kernel.Pilot;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ivan on 25/04/2016.
 */
public class HighChartsInterpretor {

    public static Dashboard interprete(Map<String,JSONObject> visualizations) throws VariableNotExistingException, IOException, VariableAmbigousConflictException, FMEngineException {

        Dashboard dash = new Dashboard(Scenario.DASHBOARD);
        View view = new View(Scenario.VIEW);
        dash.addView(view);

        for( String visuName : visualizations.keySet()) {
            Visualization visu = new Visualization(visuName);
            view.addVisualization(visu);
            JSONObject code = visualizations.get(visuName);

            // collect the types of chart used in the visualization
            List<String> types = new ArrayList<>();

            // collect the data series used in the visualization
            List<String> data = new ArrayList<>();

            // analyze the "chart" part of the DOM
            JSONObject chart = code.optJSONObject("chart");
            if(chart!=null){
                String type = chart.optString("type");
                Boolean polar = chart.optBoolean("polar");
                if(type!=null)
                    types.add(type);
                else if(polar)
                    types.add("polar");
            }

            // analyer the "series" part of the DOM
            JSONArray series = code.optJSONArray("series");
            if(series!=null){
                for(int i=0;i<series.length();i++) {
                    JSONObject serie = series.getJSONObject(i);
                    if(!serie.isNull("type"))
                        types.add(serie.getString("type"));
                    if(!serie.isNull("name"))
                        data.add("name");
                    if(!serie.isNull("id"))
                        data.add("id");

                    /* //TODO handle cases B and B'
                    JSONArray jsonData = serie.optJSONArray("data");
                    if(data!=null) {
                        for(int j=0;j<series.length();j++) {
                            // B'
                            JSONObject inst = jsonData.optJSONObject(i);
                        }
                    }*/
                }
            }

            //TODO what if data is a variable ?

            //TODO how to handle interactions ?

            data.forEach(d -> visu.addData(new Data(d)));
            Shelf shelf = new Shelf();
            List<String> concerns = shelf.getConcernsByReduction((String[])types.toArray());
            concerns.forEach(c -> visu.addConcern(Concern.valueOf(c)));
        }
        return dash;
    }
}
