package nodes;

import java.io.IOException;

/**
 * Factory care creaza un nod in functie de linia pe care o citesc din
 * fisierul de intrare.
 * Created by Rares Cheseli on 13-Dec-16.
 */
public class NodeFactory {
    /**
     * Returneaza un nod in functie de ce am citit din fisierul de intrare
     * @param line linia citita din fisierul de intrare
     * @param level nivelul pe care il va avea nodul nou creat
     * @return nodul corespunzator liniei pritita ca parametru
     * @throws IOException
     */
    public static Node CreateNode(String line, int level) throws IOException {
        if (line.startsWith("TALK TO THE HAND ")) {
            Node printNode = new PrintNode("nodes.PrintNode", level);
            if (line.endsWith("\"")) {
                int start = line.indexOf('\"') + 1;
                int stop = line.lastIndexOf('\"');
                line = line.substring(start, stop);
                Node stringNode = new StringNode("nodes.StringNode", level + 1,line);
                printNode.addChildren(stringNode);
            } else {
                String value = line.substring(line.lastIndexOf(" ") + 1);
                AST ast = AST.getInstance();
                Node node;
                if (ast.checkKey(value)) {
                    node = new VariableNode("nodes.VariableNode", level + 1,value);
                } else {
                    node = new ConstantNode("nodes.ConstantNode", level + 1, value);
                }
                printNode.addChildren(node);
            }
            return printNode;
        }

        if (line.startsWith("HEY CHRISTMAS TREE ")) {
            String value = line.substring(line.lastIndexOf(" ") + 1);
            Node declareNode = new DeclareNode("nodes.DeclareNode", level);
            Node lvalNode = new LvalNode("nodes.LvalNode", level + 1, value);

            while (line.startsWith("YOU SET US UP ") == false) {
                line = Reader.getInstance().getBr().readLine();
                line = line.trim().replaceAll("\\s+", " ");
            }

            String constantValue = null;
            if (line.startsWith("YOU SET US UP @")) {
                if (line.endsWith("@I LIED")) {
                    constantValue = "0";
                }
                if (line.endsWith("@NO PROBLEMO")) {
                    constantValue = "1";
                }
            } else {
                constantValue = line.substring(line.lastIndexOf(" ") + 1);
            }

            AST.getInstance().addVariable(value, constantValue);
            Node constNode =
                    new ConstantNode("nodes.ConstantNode", level + 1, constantValue);
            declareNode.addChildren(lvalNode);
            declareNode.addChildren(constNode);
            return declareNode;
        }

        if (line.startsWith("GET TO THE CHOPPER ")) {
            String value = line.substring(line.lastIndexOf(" ") + 1);
            Node assignNode = new AssignmentNode("nodes.AssignmentNode", level);
            Node lvalNode = new LvalNode("nodes.LvalNode", level + 1, value);
            assignNode.addChildren(lvalNode);
            return assignNode;
        }

        if (line.startsWith("CONSIDER THAT A DIVORCE ")) {
            Node orNode = new OrNode("nodes.OrNode", level + 1);
            orNode.addChildren(MakeLeaf(line, level + 1));
            return orNode;
        }

        if (line.startsWith("KNOCK KNOCK ")) {
            Node andNode = new AndNode("nodes.AndNode", level + 1);
            andNode.addChildren(MakeLeaf(line, level + 1));
            return andNode;
        }

        if (line.startsWith("GET UP ")) {
            Node sumNode = new SumNode("nodes.SumNode", level + 1);
            sumNode.addChildren(MakeLeaf(line, level + 1));
            return sumNode;
        }

        if (line.startsWith("GET DOWN ")) {
            Node diffNode = new DifferenceNode("nodes.DifferenceNode", level + 1);
            diffNode.addChildren(MakeLeaf(line, level + 1));
            return diffNode;
        }

        if (line.startsWith("YOU'RE FIRED ")) {
            Node mulNode = new MultiplicationNode("nodes.MultiplicationNode", level + 1);
            mulNode.addChildren(MakeLeaf(line, level + 1));
            return mulNode;
        }

        if (line.startsWith("HE HAD TO SPLIT ")) {
            Node divNode = new DivisionNode("nodes.DivisionNode", level + 1);
            divNode.addChildren(MakeLeaf(line, level + 1));
            return divNode;
        }

        if (line.startsWith("HERE IS MY INVITATION ")) {
            return MakeLeaf(line, level);
        }

        if (line.startsWith("I LET HIM GO ")) {
            Node moduloNode = new ModuloNode("nodes.ModuloNode", level + 1);
            moduloNode.addChildren(MakeLeaf(line, level + 1));
            return moduloNode;
        }

        if (line.startsWith("YOU ARE NOT YOU YOU ARE ME ")) {
            Node equalNode = new EqualToNode("nodes.EqualToNode", level + 1);
            equalNode.addChildren(MakeLeaf(line, level + 1));
            return equalNode;
        }

        if (line.startsWith("LET OFF SOME STEAM BENNET ")) {
            Node greatNode = new GreaterThanNode("nodes.GreaterThanNode", level + 1);
            greatNode.addChildren(MakeLeaf(line, level + 1));
            return greatNode;
        }

        if (line.startsWith("STICK AROUND ")) {
            Node whileNode = new WhileNode("nodes.WhileNode", level);
            String value = line.substring(line.lastIndexOf(" ") + 1);
            Node condNode = new ConditionNode("nodes.ConditionNode", level + 1,value);
            whileNode.addChildren(condNode);
            return whileNode;
        }

        if (line.startsWith("BECAUSE I'M GOING TO SAY PLEASE ")) {
            Node ifNode = new IfNode("nodes.IfNode", level);
            String value = line.substring(line.lastIndexOf(" ") + 1);
            Node condNode = new ConditionNode("nodes.ConditionNode", level + 1,value);
            ifNode.addChildren(condNode);
            return ifNode;
        }
        return null;
    }

    /**
     * Creaza o frunza in asrborele sintactic
     * @param line linia citita din fisierul de intrare
     * @param level nivelul frunzei
     * @return rvalNode sau nodes.ConstantNode in functie de linia primita ca parametru
     */
    private static Node MakeLeaf(String line, int level) {
        String newVal = line.substring(line.lastIndexOf(" ") + 1);
        AST ast = AST.getInstance();
        if (line.endsWith("@I LIED")) {
            newVal = "0";
        }
        if (line.endsWith("@NO PROBLEMO")) {
            newVal = "1";
        }

        if (ast.checkKey(newVal)) {
            return new RvalNode("nodes.RvalNode", level + 1, newVal);
        } else {
            return new ConstantNode("nodes.ConstantNode", level + 1, newVal);
        }
    }
}
