package nodes;

import visitor.Visitor;

import java.io.IOException;

/**
 * Created by Rares Cheseli on 13-Dec-16.
 */
public class IfNode extends Node{
    public IfNode(String name, int level) {
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
        boolean iHaveElse = false;
        int level = this.getLevel();

        Node ifBodyNode = new IfBodyNode("nodes.IfBodyNode", level + 1);
        Node elseNode = new ElseBodyNode("nodes.ElseBodyNode",  level + 1);
        while (line.equals("YOU HAVE NO RESPECT FOR LOGIC") == false) {
            if (line.length() < 5) {
                line = Reader.getInstance().getBr().readLine();
                line = line.trim().replaceAll("\\s+", " ");
                continue;
            }
            if (line.equals("BULLSHIT")) {
                iHaveElse = true;
            }

            Node newNode = NodeFactory.CreateNode(line, level + 2);
            if (newNode != null) {
                newNode.build();

                if (iHaveElse == true) {
                    elseNode.addChildren(newNode);
                } else {
                    ifBodyNode.addChildren(newNode);
                }
            }
            line = Reader.getInstance().getBr().readLine();
            line = line.trim().replaceAll("\\s+", " ");
        }

        if (iHaveElse == true) {
            this.addChildren(ifBodyNode);
            this.addChildren(elseNode);
        } else {
            this.addChildren(ifBodyNode);
        }
    }
}
