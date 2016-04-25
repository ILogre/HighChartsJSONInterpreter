import exceptions.FileIsNotAccessible;
import highcharts.HighChartsJSONExtractor;

import java.io.File;
import java.io.IOException;

/**
 * Created by ivan on 25/04/2016.
 */
public class Scenario {

    public static final String PATH_TO_ROOT_FOLDER = "resources/";

    public static void main(String [] args){
        try {
            HighChartsJSONExtractor.extract(new File(PATH_TO_ROOT_FOLDER+"line-basic_index.htm"));
        } catch (FileIsNotAccessible fileIsNotAccessible) {
            fileIsNotAccessible.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
