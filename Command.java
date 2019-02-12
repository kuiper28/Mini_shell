import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author kuiper
 * Interfata Command implementata
 * de toate de toate comenziile care
 * se vor executa.
 */
public interface Command {
   
    void execute (ArrayList<HeadFolder> h, int [] v, ArrayList<root> s,
            BufferedWriter wr,ArrayList<root> cdKeeper,String[] tok,
            BufferedWriter err)throws IOException;
}
