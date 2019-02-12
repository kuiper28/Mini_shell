import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 * @author kuiper
 * 
 * Interfata root implemetata 
 * de catre clasele Folder, File.
 * 
 */
public interface root {
    
    void printFolder (BufferedWriter wr)throws IOException;
    String getName();
}
