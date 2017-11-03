package visitor;

import nodes.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * visitor.Visitor pentru afisarea fiecarui nod din nodes.AST
 * Created by Rares Cheseli on 13-Dec-16.
 */
public class PrintTreeVisitor implements Visitor {
    private PrintWriter outputFile;
    public PrintTreeVisitor(String fileName) throws FileNotFoundException {
        File outFile = new File("./output/" + fileName + ".ast");
        outputFile = new PrintWriter(outFile);
    }

    /**
     * Afiseaza numarul de taburi aferent nivelului pe care se afla nodul
     * @param node nodul pentru care trebuie afisat deplasamentul
     */
    private void printAlignment(Node node) {
        for (int i = 0; i < node.getLevel(); ++i) {
            outputFile.print('\t');
        }
    }

    @Override
    public void visit(AndNode node) {
        printAlignment(node);
        outputFile.println(node.getName());
    }

    @Override
    public void visit(AssignmentNode node) {
        printAlignment(node);
        outputFile.println(node.getName());
    }

    @Override
    public void visit(BodyNode node) {
        printAlignment(node);
        outputFile.println(node.getName());
    }

    @Override
    public void visit(ConditionNode node) {
        printAlignment(node);
        outputFile.println(node.getName() + " <" + node.getValue() + ">");
    }

    @Override
    public void visit(ConstantNode node) {
        printAlignment(node);
        outputFile.println(node.getName() + " <" + node.getValue() + ">");
    }

    @Override
    public void visit(DeclareNode node) {
        printAlignment(node);
        outputFile.println(node.getName());
    }

    @Override
    public void visit(DifferenceNode node) {
        printAlignment(node);
        outputFile.println(node.getName());
    }

    @Override
    public void visit(DivisionNode node) {
        printAlignment(node);
        outputFile.println(node.getName());
    }

    @Override
    public void visit(ElseBodyNode node) {
        printAlignment(node);
        outputFile.println(node.getName());
    }

    @Override
    public void visit(EqualToNode node) {
        printAlignment(node);
        outputFile.println(node.getName());
    }

    @Override
    public void visit(GreaterThanNode node) {
        printAlignment(node);
        outputFile.println(node.getName());
    }

    @Override
    public void visit(IfBodyNode node) {
        printAlignment(node);
        outputFile.println(node.getName());
    }

    @Override
    public void visit(IfNode node) {
        printAlignment(node);
        outputFile.println(node.getName());
    }

    @Override
    public void visit(LvalNode node) {
        printAlignment(node);
        outputFile.println(node.getName() + " <" + node.getValue() + ">");
    }

    @Override
    public void visit(MainNode node) {
        printAlignment(node);
        outputFile.println(node.getName());
    }

    @Override
    public void visit(ModuloNode node) {
        printAlignment(node);
        outputFile.println(node.getName());
    }

    @Override
    public void visit(MultiplicationNode node) {
        printAlignment(node);
        outputFile.println(node.getName());
    }

    @Override
    public void visit(OrNode node) {
        printAlignment(node);
        outputFile.println(node.getName());
    }

    @Override
    public void visit(PrintNode node) {
        printAlignment(node);
        outputFile.println(node.getName());
    }

    @Override
    public void visit(RvalNode node) {
        printAlignment(node);
        outputFile.println(node.getName() + " <" + node.getValue() + ">");
    }

    @Override
    public void visit(SumNode node) {
        printAlignment(node);
        outputFile.println(node.getName());
    }

    @Override
    public void visit(StringNode node) {
        printAlignment(node);
        outputFile.println(node.getName() + " <" + node.getValue() + ">");
    }

    @Override
    public void visit(VariableNode node) {
        printAlignment(node);
        outputFile.println(node.getName() + " <" + node.getValue() + ">");
    }

    @Override
    public void visit(WhileNode node) {
        printAlignment(node);
        outputFile.println(node.getName());
    }

    /**
     * Metoda care inchide fisierul de iesire
     */
    public void closeOutput() {
        outputFile.close();
    }
}
