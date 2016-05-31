package PivotModel;

import EntryPoint.Shelf;
import EntryPoint.Universe;
import exception.*;
import fr.familiar.interpreter.VariableNotExistingException;
import fr.familiar.parser.VariableAmbigousConflictException;

import java.io.IOException;
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

    public void addConcernByConcreteWidget(String concreteWidget){
        try {
            Shelf shelf = new Shelf();
            for(String s : shelf.getConcernsByReduction(concreteWidget))
                this.concerns.add(Concern.valueOf(s));
        } catch (VariableNotExistingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (VariableAmbigousConflictException e) {
            e.printStackTrace();
        } catch (FMEngineException e) {
            e.printStackTrace();
        }
    }

}
