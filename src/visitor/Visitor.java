package visitor;

import nodes.*;

/**
 * Interfata pentru visitor
 * Created by Rares Cheseli on 13-Dec-16.
 */
public interface Visitor {
    void visit(AndNode node);
    void visit(AssignmentNode node);
    void visit(BodyNode node);
    void visit(ConditionNode node);
    void visit(ConstantNode node);
    void visit(DeclareNode node);
    void visit(DifferenceNode node);
    void visit(DivisionNode node);
    void visit(ElseBodyNode node);
    void visit(EqualToNode node);
    void visit(GreaterThanNode node);
    void visit(IfBodyNode node);
    void visit(IfNode node);
    void visit(LvalNode node);
    void visit(MainNode node);
    void visit(ModuloNode node);
    void visit(MultiplicationNode node);
    void visit(OrNode node);
    void visit(PrintNode node);
    void visit(RvalNode node);
    void visit(SumNode node);
    void visit(StringNode node);
    void visit(VariableNode node);
    void visit(WhileNode node);
}
