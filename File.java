import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 * @author kuiper
 * Clasa File implementeaza 
 * interfata root. O instanta
 * a clasei File va face parte
 * din sistemul de fisiere.
 */
public class File implements root {
    private String name;
    
    public File (String name) {
        this.name = name;
    }
    
    public void printFolder (BufferedWriter wr)throws IOException {
        wr.write (this.name);
    }
    public String getName () {
        return this.name;
    }
    
}
