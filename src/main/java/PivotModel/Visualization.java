package PivotModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 25/04/2016.
 */
public class Visualization extends Concernable{

    private List<Data> usedData;
    private List<Interaction> interactions;

    public Visualization(String name) {
        super(name);
        this.usedData = new ArrayList<>();
        this.interactions = new ArrayList<>();
    }

    public List<Interaction> getInteractions() {
        return interactions;
    }

    public void addInteraction(Interaction i){
        if (!this.interactions.contains(i))
            this.interactions.add(i);
    }

    public List<Data> getUsedData() {
        return usedData;
    }

    public void addData(Data d){
        if (!this.usedData.contains(d))
            this.usedData.add(d);
    }
}
