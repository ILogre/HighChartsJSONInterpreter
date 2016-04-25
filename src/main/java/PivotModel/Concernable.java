package PivotModel;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 25/04/2016.
 */
public abstract class Concernable extends NamedElement{
    private List<Concern> concerns;

    public Concernable(String name) {
        super(name);
        this.concerns = new ArrayList<Concern>();
    }

    public Concernable(String name, List<Concern> concerns) {
        super(name);
        this.concerns = concerns;
    }

    public List<Concern> getConcerns() {
        return concerns;
    }

    public void addConcern(Concern c){
        if (!this.concerns.contains(c))
            this.concerns.add(c);
    }

}
