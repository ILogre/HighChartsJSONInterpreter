package highcharts;

import exceptions.FileIsNotAccessible;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static java.nio.file.Files.lines;

/**
 * Created by ivan on 25/04/2016.
 */
public class HighChartsJSONExtractor {


    public static final String BEGIN_DETECT_VISU = "$('#";
    public static final String END_DETECT_VISU = "').highcharts(";

    public static JSONObject extract(File file) throws FileIsNotAccessible, IOException {
        //check the existence of the file
        if (!file.exists() || !file.canRead())
            throw new FileIsNotAccessible("Input file does not exist or is not readable."+"\n"+file.getAbsolutePath());

        StringBuilder sb = new StringBuilder();
        // JSON does not handle comments so we remove it
        Files.lines(file.toPath()).map(s ->  removeComments(s)).forEach(l -> sb.append(l));
        String content = sb.toString();

        // we delete the beginning of the file until we find the name of the visualization
        content = content.substring(content.indexOf(BEGIN_DETECT_VISU)+ BEGIN_DETECT_VISU.length());
        String  visuName = content.substring(0,content.indexOf("'"));

        // we delete tokens until the beginning of the JSON object representing the visualization
        String JSONcontent = content.substring(content.indexOf(END_DETECT_VISU)+ END_DETECT_VISU.length());
        return new JSONObject(JSONcontent);
    }

    private static String removeComments(String s){
        String res = s;
        if(s.contains("//"))
            res = s.substring(0,s.indexOf("//"));
        return res;
    }
}
