package PivotModel;

/**
 * Created by ivan on 25/04/2016.
 */
public class Interaction {
    private Visualization source;
    private Visualization target;

    public Interaction(Visualization source, Visualization target) {
        this.source = source;
        this.target = target;
    }

    public Visualization getTarget() {
        return target;
    }

    public Visualization getSource() {
        return source;
    }
}
