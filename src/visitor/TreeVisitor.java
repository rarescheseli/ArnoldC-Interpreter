package visitor;

import nodes.*;
import visitor.Visitor;

import java.util.LinkedList;

/**
 * visitor.Visitor pentru a afisa arborele.
 * Primeste ca parametru un baseVisitor cu care afiseaza fiecare nod, in
 * functie de tipul nodului.
 * Created by Rares Cheseli on 13-Dec-16.
 */
public class TreeVisitor implements Visitor {
    /**
     * visitor.Visitor cu care afisez fiecare nod
     */
    private Visitor baseVisitor;

    public TreeVisitor(Visitor baseVisitor) {
        this.baseVisitor = baseVisitor;
    }

    @Override
    public void visit(AndNode node) {
        node.accept(baseVisitor);
        LinkedList <Node> children = node.getChildren();
        for (Node crtNode : children) {
            crtNode.accept(this);
        }
    }

    @Override
    public void visit(AssignmentNode node) {
        node.accept(baseVisitor);
        LinkedList <Node> children = node.getChildren();
        for (Node crtNode : children) {
            crtNode.accept(this);
        }
    }

    @Override
    public void visit(BodyNode node) {
        node.accept(baseVisitor);
        LinkedList <Node> children = node.getChildren();
        for (Node crtNode : children) {
            crtNode.accept(this);
        }
    }

    @Override
    public void visit(ConditionNode node) {
        node.accept(baseVisitor);
    }

    @Override
    public void visit(ConstantNode node) {
        node.accept(baseVisitor);
    }

    @Override
    public void visit(DeclareNode node) {
        node.accept(baseVisitor);
        LinkedList <Node> children = node.getChildren();
        for (Node crtNode : children) {
            crtNode.accept(this);
        }
    }

    @Override
    public void visit(DifferenceNode node) {
        node.accept(baseVisitor);
        LinkedList <Node> children = node.getChildren();
        for (Node crtNode : children) {
            crtNode.accept(this);
        }
    }

    @Override
    public void visit(DivisionNode node) {
        node.accept(baseVisitor);
        LinkedList <Node> children = node.getChildren();
        for (Node crtNode : children) {
            crtNode.accept(this);
        }
    }

    @Override
    public void visit(ElseBodyNode node) {
        node.accept(baseVisitor);
        LinkedList <Node> children = node.getChildren();
        for (Node crtNode : children) {
            crtNode.accept(this);
        }
    }

    @Override
    public void visit(EqualToNode node) {
        node.accept(baseVisitor);
        LinkedList <Node> children = node.getChildren();
        for (Node crtNode : children) {
            crtNode.accept(this);
        }
    }

    @Override
    public void visit(GreaterThanNode node) {
        node.accept(baseVisitor);
        LinkedList <Node> children = node.getChildren();
        for (Node crtNode : children) {
            crtNode.accept(this);
        }
    }

    @Override
    public void visit(IfBodyNode node) {
        node.accept(baseVisitor);
        LinkedList <Node> children = node.getChildren();
        for (Node crtNode : children) {
            crtNode.accept(this);
        }
    }

    @Override
    public void visit(IfNode node) {
        node.accept(baseVisitor);
        LinkedList <Node> children = node.getChildren();
        for (Node crtNode : children) {
            crtNode.accept(this);
        }
    }

    @Override
    public void visit(LvalNode node) {
        node.accept(baseVisitor);
    }

    @Override
    public void visit(MainNode node) {
        node.accept(baseVisitor);
        LinkedList <Node> children = node.getChildren();
        for (Node crtNode : children) {
            crtNode.accept(this);
        }
    }

    @Override
    public void visit(ModuloNode node) {
        node.accept(baseVisitor);
        LinkedList <Node> children = node.getChildren();
        for (Node crtNode : children) {
            crtNode.accept(this);
        }
    }

    @Override
    public void visit(MultiplicationNode node) {
        node.accept(baseVisitor);
        LinkedList <Node> children = node.getChildren();
        for (Node crtNode : children) {
            crtNode.accept(this);
        }
    }

    @Override
    public void visit(OrNode node) {
        node.accept(baseVisitor);
        LinkedList <Node> children = node.getChildren();
        for (Node crtNode : children) {
            crtNode.accept(this);
        }
    }

    @Override
    public void visit(PrintNode node) {
        node.accept(baseVisitor);
        LinkedList <Node> children = node.getChildren();
        for (Node crtNode : children) {
            crtNode.accept(this);
        }
    }

    @Override
    public void visit(RvalNode node) {
        node.accept(baseVisitor);
    }

    @Override
    public void visit(SumNode node) {
        node.accept(baseVisitor);
        LinkedList <Node> children = node.getChildren();
        for (Node crtNode : children) {
            crtNode.accept(this);
        }
    }

    @Override
    public void visit(StringNode node) {
        node.accept(baseVisitor);
    }

    @Override
    public void visit(VariableNode node) {
        node.accept(baseVisitor);
    }

    @Override
    public void visit(WhileNode node) {
        node.accept(baseVisitor);
        LinkedList <Node> children = node.getChildren();
        for (Node crtNode : children) {
            crtNode.accept(this);
        }
    }
}