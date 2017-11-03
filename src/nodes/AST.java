package nodes;

import visitor.InterpretVisitor;
import visitor.PrintTreeVisitor;
import visitor.TreeVisitor;
import visitor.Visitor;
import reader.Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Rares Cheseli on 13-Dec-16.
 */
public class AST {
    private Node main;
    private static AST ourInstance = null;

    /**
     * Hash in care sunt toate variabilele declarate si valoarea lor
     */
    private HashMap <String, String> variables;
    private AST() {
        main = new MainNode("nodes.MainNode", 0);
        variables = new HashMap<String, String>();
    }

    public static AST getInstance() {
        if (ourInstance == null) {
            ourInstance = new AST();
        }
        return ourInstance;
    }

    /**
     * Parseaza fisierul de intrare si construieste nodes.AST-ul
     * @param file fisierul din care se citeste inputul
     * @throws IOException
     */
    public void buildTree(File file) throws IOException {
        Reader reader = Reader.getInstance();
        reader.init(file);
        String line = reader.getBr().readLine();
        line = line.trim().replaceAll("\\s+", " ");

        while (line.equals("IT'S SHOWTIME") == false) {
            line = reader.getBr().readLine();
            line = line.trim().replaceAll("\\s+", " ");
        }

        main.build();
        reader.closeInput();
    }

    /**
     * Adauga o noua variabila in hash
     * @param key numele variabilei
     * @param value valoarea variabilei
     */
    public void addVariable(String key, String value) {
        variables.put(key, value);
    }

    /**
     * Modifica valoare unei variabile deja existente in hash.
     * Folosita la assignment
     * @param key numele variabilei ce trebuie modificata
     * @param value noua valoare a variabilei
     */
    public void modifyVariable(String key, String value) {
        variables.remove(key);
        variables.put(key, value);
    }

    /**
     * Verifica daca o variabila a fost deja declarata
     * @param key numele variabilei ce trebuie verificata
     * @return true daca variabila exista deja si 0 altfel
     */
    public boolean checkKey(String key) {
        return variables.containsKey(key);
    }

    public String getValue(String key) {
        return variables.get(key);
    }

    /**
     * Printeaza nodes.AST-ul format dupa parsarea inputului
     * @throws FileNotFoundException
     */
    public void printTree() throws FileNotFoundException {
        String prefix = Reader.getInstance().getFileNamePrefix();
        PrintTreeVisitor printVisitor = new PrintTreeVisitor(prefix);
        Visitor treeVisitor = new TreeVisitor(printVisitor);
        main.accept(treeVisitor);
        printVisitor.closeOutput();
    }

    /**
     * Interpreteaza nodes.AST-ul si afiseaza rezultatul interpretarii
     * @throws FileNotFoundException
     */
    public void interpret() throws FileNotFoundException {
        String prefix = Reader.getInstance().getFileNamePrefix();
        Visitor interpretVisitor = new InterpretVisitor(prefix);
        main.accept(interpretVisitor);
        ((InterpretVisitor) interpretVisitor).closeOutput();
    }
}
