package nodes;

import java.io.File;
import java.io.IOException;

/**
 * Created by Rares Cheseli on 13-Dec-16.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        AST astInstance = AST.getInstance();
        try {
            astInstance.buildTree(new File(args[0]));
            astInstance.printTree();
            astInstance.interpret();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
