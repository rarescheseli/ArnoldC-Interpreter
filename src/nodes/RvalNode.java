package nodes;

import visitor.Visitor;

import java.io.IOException;

/**
 * Created by Rares Cheseli on 13-Dec-16.
 */
public class RvalNode extends Node {
    public RvalNode(String name, int level, String value) {
        super(name, level);
        this.setValue(value);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void build() throws IOException {}
}
