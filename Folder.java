import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kuiper
 * Clasa Folder implementeaza 
 * interfata root. O instanta
 * a clasei Folder va face parte
 * din sistemul de fisiere.
 */
public class Folder implements root{
    
    String name;
    int index = 0;
    public Folder (String name) {
        this.name = name;
    }
    public void printFolder (BufferedWriter wr) throws IOException {
        wr.write (this.name);
    }
    public String getName () {
        return this.name;
    }

    
}
