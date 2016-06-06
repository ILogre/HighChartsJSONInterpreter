package PivotModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 25/04/2016.
 */
public class Dashboard extends NamedElement{

    private List<View> views;

    public Dashboard(String name, List<View> views) {
        super(name);
        this.views = views;
    }

    public Dashboard(String name) {
        super(name);
        this.views = new ArrayList<>();
    }

    public List<View> getViews() {
        return views;
    }

    public void addView(View v){
        if (!this.views.contains(v))
            this.views.add(v);
    }

}
