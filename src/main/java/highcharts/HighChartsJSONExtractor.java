package highcharts;


import exceptions.FileIsNotAccessible;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by ivan on 25/04/2016.
 */
public class HighChartsJSONExtractor {


    public static final String BEGIN_DETECT_VISU = "$('#";
    public static final String END_DETECT_VISU = "').highcharts(";

    public static Map<String,JSONObject> extract(File file) throws FileIsNotAccessible, IOException {
        //check the existence of the file
        if (!file.exists() || !file.canRead())
            throw new FileIsNotAccessible("Input file does not exist or is not readable."+"\n"+file.getAbsolutePath());

        StringBuilder sb = new StringBuilder();
        // JSON does not handle comments so we remove it
        Files.lines(file.toPath()).map(s ->  removeComments(s)).forEach(l -> sb.append(l));
        String dashboard = sb.toString();

        Map result = new HashMap<>();

        String[] visus = dashboard.split("var (\\w)* = \\$\\(\\'\\#");
        visus[visus.length-1] = visus[visus.length-1].substring(0, visus[visus.length-1].indexOf("</script>"));

        for (int i =1; i<visus.length;i++) {
            String content = visus[i].trim();
            // we delete the beginning of the file until we find the name of the next visualization
            //content = content.substring(content.indexOf(BEGIN_DETECT_VISU) + BEGIN_DETECT_VISU.length());
            String visuName = content.substring(0, content.indexOf("'"));

            // we delete tokens until the beginning of the JSON object representing the visualization
            String JSONcontent = content.substring(content.indexOf(END_DETECT_VISU) + END_DETECT_VISU.length());
            result.put(visuName, new JSONObject(JSONcontent));
        }

        return result;
    }

    private static String removeComments(String s){
        String res = s;
        if(s.contains("//"))
            res = s.substring(0,s.indexOf("//"));
        return res;
    }
}
