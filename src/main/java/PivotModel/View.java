package PivotModel;

import java.util.List;

/**
 * Created by ivan on 25/04/2016.
 */
public class View extends NamedElement{
    private List<Visualization> visualizations;

    public View(String name, List<Visualization> visualizations) {
        super(name);
        this.visualizations = visualizations;
    }

    public List<Visualization> getVisualizations() {
        return visualizations;
    }

    public void addVisualization(Visualization v){
        if(!this.visualizations.contains(v))
            this.visualizations.add(v);
    }
}
