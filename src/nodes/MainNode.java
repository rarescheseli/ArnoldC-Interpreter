package nodes;

import visitor.Visitor;

import java.io.IOException;

/**
 * Nodul radacina al arborelui sintactic
 * Created by Rares Cheseli on 13-Dec-16.
 */
public class MainNode extends Node {
    public MainNode(String name, int level) {
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

        while (line.equals("YOU HAVE BEEN TERMINATED") == false) {
            if (line.length() < 5) {
                line = Reader.getInstance().getBr().readLine();
                line = line.trim().replaceAll("\\s+", " ");
                continue;
            }

            Node newNode = NodeFactory.CreateNode(line, this.getLevel() + 1);
            if (newNode != null) {
                newNode.build();
                this.addChildren(newNode);
            }
            line = Reader.getInstance().getBr().readLine();
            line = line.trim().replaceAll("\\s+", " ");
        }
    }
}
