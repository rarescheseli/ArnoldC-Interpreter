package reader;

import java.io.*;

/**
 * Singleton cu ajutorul caruia citesc din fisierul de intrare
 * Created by Rares Cheseli on 13-Dec-16.
 */
public class Reader {
    /**
     * Numele fisierului de intrare
     */
    private String fileName;

    /**
     * Bufferul din care citesc
     */
    private BufferedReader br;
    private static Reader ourInstance = null;

    private Reader() {}

    /**
     * Functie pentru initializarea bufferului cu fisierul de intrare
     */
    public void init(File file) {
        try {
            br = new BufferedReader(new FileReader(file));
            fileName = file.getName();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Reader getInstance() {
        if (ourInstance == null) {
            ourInstance = new Reader();
        }

        return ourInstance;
    }

    public BufferedReader getBr() {
        return br;
    }

    /**
     * Metoda pentru a lua prefixul unu fisier de intrare
     * @return prefixul fisierului de intrare
     */
    public String getFileNamePrefix() {
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    public void closeInput() throws IOException {
        br.close();
    }
}
