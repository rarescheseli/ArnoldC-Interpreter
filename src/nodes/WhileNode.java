package nodes;

import visitor.Visitor;

import java.io.IOException;

/**
 * Created by Rares Cheseli on 13-Dec-16.
 */
public class WhileNode extends Node {
    public WhileNode(String name, int level) {
        super(name, level);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void build() throws IOException {
        String line = Reader.getInstance().getBr().readLine();
        line = line.trim().replaceAll("\\s+", " ");

        Node bodyNode = new BodyNode("nodes.BodyNode", this.getLevel() + 1);
        while (line.equals("CHILL") == false) {
            if (line.length() < 5) {
                line = Reader.getInstance().getBr().readLine();
                line = line.trim().replaceAll("\\s+", " ");
                continue;
            }

            Node newNode = NodeFactory.CreateNode(line, this.getLevel() + 2);
            if (newNode != null) {
                newNode.build();
                bodyNode.addChildren(newNode);
            }
            line = Reader.getInstance().getBr().readLine();
            line = line.trim().replaceAll("\\s+", " ");
        }
        this.addChildren(bodyNode);
    }
}
