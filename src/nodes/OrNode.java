package nodes;

import visitor.Visitor;

import java.io.IOException;

/**
 * Created by Rares Cheseli on 13-Dec-16.
 */
public class OrNode extends Node {
    public OrNode(String name, int level) {
        super(name, level);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void build() throws IOException {}
}
