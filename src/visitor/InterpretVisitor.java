package visitor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import nodes.*;
import java.util.LinkedList;

/**
 * Clasa pentru a interpreta arborele. Prima data se interpreteaza toti
 * descendentii unui noi, apoi se interpreteaza nodul.
 * Created by Rares Cheseli on 13-Dec-16.
 */
public class InterpretVisitor implements Visitor {
    private PrintWriter outputFile;
    public InterpretVisitor(String fileName) throws FileNotFoundException {
        File outFile = new File("./output/" + fileName + ".out");
        outputFile = new PrintWriter(outFile);
    }

    @Override
    public void visit(AndNode node) {
        int size = node.getChildren().size();
        for (int i = 0; i < size; ++i) {
            node.getChildren().get(i).accept(this);
        }
        String rval1 = node.getChildren().get(0).getValue();
        String rval2 = node.getChildren().get(1).getValue();
        int intRval1;
        int intRval2;
        if (rval1.matches("[0-9]+")) {
            intRval1 = Integer.parseInt(rval1);
        } else {
            intRval1 = Integer.parseInt(AST.getInstance().getValue(rval1));
        }

        if (rval2.matches("[0-9]+")) {
            intRval2 = Integer.parseInt(rval2);
        } else {
            intRval2 = Integer.parseInt(AST.getInstance().getValue(rval2));
        }
        if (intRval1 != 0 && intRval2 != 0) {
            node.setValue("1");
        } else {
            node.setValue("0");
        }
    }

    @Override
    public void visit(AssignmentNode node) {
        for (Node crtNode : node.getChildren()) {
            crtNode.accept(this);
        }
        LinkedList <Node> kids = node.getChildren();
        String source = kids.get(1).getValue();
        String destination = kids.get(0).getValue();

        if (AST.getInstance().checkKey(source)) {
            source = AST.getInstance().getValue(source);
        }
        AST.getInstance().modifyVariable(destination, source);
    }

    @Override
    public void visit(BodyNode node) {
        for (Node crtNode : node.getChildren()) {
            crtNode.accept(this);
        }
    }

    @Override
    public void visit(ConditionNode node) {}

    @Override
    public void visit(ConstantNode node) {}

    @Override
    public void visit(DeclareNode node) {}

    @Override
    public void visit(DifferenceNode node) {
        int size = node.getChildren().size();
        for (int i = 0; i < size; ++i) {
            node.getChildren().get(i).accept(this);
        }
        String rval1 = node.getChildren().get(0).getValue();
        String rval2 = node.getChildren().get(1).getValue();
        int intRval1;
        int intRval2;
        if (rval1.matches("[0-9]+")) {
            intRval1 = Integer.parseInt(rval1);
        } else {
            intRval1 = Integer.parseInt(AST.getInstance().getValue(rval1));
        }

        if (rval2.matches("[0-9]+")) {
            intRval2 = Integer.parseInt(rval2);
        } else {
            intRval2 = Integer.parseInt(AST.getInstance().getValue(rval2));
        }
        node.setValue(Integer.toString(intRval1 - intRval2));
    }

    @Override
    public void visit(DivisionNode node) {
        int size = node.getChildren().size();
        for (int i = 0; i < size; ++i) {
            node.getChildren().get(i).accept(this);
        }
        String rval1 = node.getChildren().get(0).getValue();
        String rval2 = node.getChildren().get(1).getValue();
        int intRval1;
        int intRval2;
        if (rval1.matches("[0-9]+")) {
            intRval1 = Integer.parseInt(rval1);
        } else {
            intRval1 = Integer.parseInt(AST.getInstance().getValue(rval1));
        }

        if (rval2.matches("[0-9]+")) {
            intRval2 = Integer.parseInt(rval2);
        } else {
            intRval2 = Integer.parseInt(AST.getInstance().getValue(rval2));
        }
        node.setValue(Integer.toString(intRval1 / intRval2));
    }

    @Override
    public void visit(ElseBodyNode node) {
        for (Node crtNode : node.getChildren()) {
            crtNode.accept(this);
        }
    }

    @Override
    public void visit(EqualToNode node) {
        int size = node.getChildren().size();
        for (int i = 0; i < size; ++i) {
            node.getChildren().get(i).accept(this);
        }
        String rval1 = node.getChildren().get(0).getValue();
        String rval2 = node.getChildren().get(1).getValue();
        int intRval1;
        int intRval2;
        if (rval1.matches("[0-9]+")) {
            intRval1 = Integer.parseInt(rval1);
        } else {
            intRval1 = Integer.parseInt(AST.getInstance().getValue(rval1));
        }

        if (rval2.matches("[0-9]+")) {
            intRval2 = Integer.parseInt(rval2);
        } else {
            intRval2 = Integer.parseInt(AST.getInstance().getValue(rval2));
        }
        if (intRval1 == intRval2) {
            node.setValue("1");
        } else {
            node.setValue("0");
        }
    }

    @Override
    public void visit(GreaterThanNode node) {
        int size = node.getChildren().size();
        for (int i = 0; i < size; ++i) {
            node.getChildren().get(i).accept(this);
        }
        String rval1 = node.getChildren().get(0).getValue();
        String rval2 = node.getChildren().get(1).getValue();
        int intRval1;
        int intRval2;
        if (rval1.matches("[0-9]+")) {
            intRval1 = Integer.parseInt(rval1);
        } else {
            intRval1 = Integer.parseInt(AST.getInstance().getValue(rval1));
        }

        if (rval2.matches("[0-9]+")) {
            intRval2 = Integer.parseInt(rval2);
        } else {
            intRval2 = Integer.parseInt(AST.getInstance().getValue(rval2));
        }
        if (intRval1 > intRval2) {
            node.setValue("1");
        } else {
            node.setValue("0");
        }
    }

    @Override
    public void visit(IfBodyNode node) {
        for (Node crtNode : node.getChildren()) {
            crtNode.accept(this);
        }
    }

    @Override
    public void visit(IfNode node) {
        LinkedList <Node> kids = node.getChildren();
        String condition = kids.get(0).getValue();
        String value = AST.getInstance().getValue(condition);

        int intCondition = Integer.parseInt(value);

        if (intCondition != 0) {
            node.getChildren().get(1).accept(this);
        } else {
            if (node.getChildren().size() == 3) {
                node.getChildren().get(2).accept(this);
            }
        }
    }

    @Override
    public void visit(LvalNode node) {}

    @Override
    public void visit(MainNode node) {
        for (Node crtNode : node.getChildren()) {
            crtNode.accept(this);
        }
    }

    @Override
    public void visit(ModuloNode node) {
        int size = node.getChildren().size();
        for (int i = 0; i < size; ++i) {
            node.getChildren().get(i).accept(this);
        }
        String rval1 = node.getChildren().get(0).getValue();
        String rval2 = node.getChildren().get(1).getValue();
        int intRval1;
        int intRval2;
        if (rval1.matches("[0-9]+")) {
            intRval1 = Integer.parseInt(rval1);
        } else {
            intRval1 = Integer.parseInt(AST.getInstance().getValue(rval1));
        }

        if (rval2.matches("[0-9]+")) {
            intRval2 = Integer.parseInt(rval2);
        } else {
            intRval2 = Integer.parseInt(AST.getInstance().getValue(rval2));
        }
        node.setValue(Integer.toString(intRval1 % intRval2));
    }

    @Override
    public void visit(MultiplicationNode node) {
        int size = node.getChildren().size();
        for (int i = 0; i < size; ++i) {
            node.getChildren().get(i).accept(this);
        }
        String rval1 = node.getChildren().get(0).getValue();
        String rval2 = node.getChildren().get(1).getValue();
        int intRval1;
        int intRval2;
        if (rval1.matches("[0-9]+")) {
            intRval1 = Integer.parseInt(rval1);
        } else {
            intRval1 = Integer.parseInt(AST.getInstance().getValue(rval1));
        }

        if (rval2.matches("[0-9]+")) {
            intRval2 = Integer.parseInt(rval2);
        } else {
            intRval2 = Integer.parseInt(AST.getInstance().getValue(rval2));
        }
        node.setValue(Integer.toString(intRval1 * intRval2));
    }

    @Override
    public void visit(OrNode node) {
        int size = node.getChildren().size();
        for (int i = 0; i < size; ++i) {
            node.getChildren().get(i).accept(this);
        }
        String rval1 = node.getChildren().get(0).getValue();
        String rval2 = node.getChildren().get(1).getValue();
        int intRval1;
        int intRval2;
        if (rval1.matches("[0-9]+")) {
            intRval1 = Integer.parseInt(rval1);
        } else {
            intRval1 = Integer.parseInt(AST.getInstance().getValue(rval1));
        }

        if (rval2.matches("[0-9]+")) {
            intRval2 = Integer.parseInt(rval2);
        } else {
            intRval2 = Integer.parseInt(AST.getInstance().getValue(rval2));
        }
        if (intRval1 != 0 || intRval2 != 0) {
            node.setValue("1");
        } else {
            node.setValue("0");
        }
    }

    @Override
    public void visit(PrintNode node) {
        LinkedList <Node> children = node.getChildren();
        String key = children.get(0).getValue();
        AST ast = AST.getInstance();
        if (ast.checkKey(key)) {
            outputFile.println(ast.getValue(key));
        } else {
            outputFile.println(key);
        }
    }

    @Override
    public void visit(RvalNode node) {}

    @Override
    public void visit(SumNode node) {
        int size = node.getChildren().size();
        for (int i = 0; i < size; ++i) {
            node.getChildren().get(i).accept(this);
        }
        String rval1 = node.getChildren().get(0).getValue();
        String rval2 = node.getChildren().get(1).getValue();
        int intRval1;
        int intRval2;
        if (rval1.matches("[0-9]+")) {
            intRval1 = Integer.parseInt(rval1);
        } else {
            intRval1 = Integer.parseInt(AST.getInstance().getValue(rval1));
        }

        if (rval2.matches("[0-9]+")) {
            intRval2 = Integer.parseInt(rval2);
        } else {
            intRval2 = Integer.parseInt(AST.getInstance().getValue(rval2));
        }
        node.setValue(Integer.toString(intRval1 + intRval2));
    }

    @Override
    public void visit(StringNode node) {}

    @Override
    public void visit(VariableNode node) {}

    @Override
    public void visit(WhileNode node) {
        String variable = node.getChildren().get(0).getValue();
        variable = AST.getInstance().getValue(variable);
        int intCondition = Integer.parseInt(variable);

        if (intCondition != 0) {
            node.getChildren().get(1).accept(this);
            node.accept(this);
        }
    }

    public void closeOutput() {
        outputFile.close();
    }
}
