package nodes;

import visitor.Visitor;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Rares Cheseli on 13-Dec-16.
 */
public class AssignmentNode extends Node {
    public AssignmentNode(String name, int level) {
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

        ArrayList <Node> children = new ArrayList <Node>();
        while (line.equals("ENOUGH TALK") == false) {
            Node newNode = NodeFactory.CreateNode(line, this.getLevel());
            if (newNode != null) {
                children.add(newNode);
            }

            line = Reader.getInstance().getBr().readLine();
            line = line.trim().replaceAll("\\s+", " ");
        }

        if (children.size() > 1) {
            int size = children.size();
            for (int i = size - 2; i >= 0; --i) {
                children.get(i).setLevel(children.get(i + 1).getLevel() + 1);
            }

            for (int i = 1; i < size; ++i) {
                children.get(i).addFirst(children.get(i - 1));
            }

            this.addChildren(children.get(size - 1));
        } else {
            this.addChildren(children.get(0));
        }
    }
}