package nodes;

import visitor.Visitor;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Rares Cheseli on 13-Dec-16.
 */
public abstract class Node {
    /**
     * nivelul nodului in arbore
     */
    private int level;

    /**
     * numele nodului
     */
    private String name;

    /**
     * valoarea nodului folosita pentru interpretare
     */
    private String value;

    /**
     * lista cu toti descendentii directi ai nodului
     */
    LinkedList <Node> children;

    public Node(String name, int level) {
        this.name = name;
        this.level = level;
        children = new LinkedList <Node>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    /**
     * Seteaza nivelul pentru un nod si toate nodurile din subarborele nodului
     * curent
     * @param level noul nivel al nodului
     */
    public void setLevel(int level) {
        this.level = level;
        int size = children.size();
        if (size > 0) {
            for (int i = 0; i < size; ++i) {
                children.get(i).setLevel(level + 1);
            }
        }
    }

    /**
     * Adauga un descendent direct nodului curent
     * @param node nodul care trebuie adaugat ca descendent nodului curent
     */
    public void addChildren(Node node) {
        children.add(node);
    }

    /**
     * Adauga pe prima pozitie in lista de descendenti un nod
     * @param node nodul care trebuie adaugat ca descendent nodului curent
     */
    public void addFirst(Node node) {
        children.addFirst(node);
    }

    public LinkedList <Node> getChildren() {
        return children;
    }

    public abstract void accept(Visitor visitor);

    /**
     * Parseaza fisierul de intrare si nodul cu toti descendentii sai
     * @throws IOException
     */
    public abstract void build() throws IOException;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
