import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author kuiper
 * In aceasta clasa este
 * implementata comanda cd.
 */
public class CD implements Command{
    
    private String name;
    
    public CD (String name) {
        this.name = name;
    }
    
    /* In cdKeeper este retinut locul in care ma aflu dupa
       executia comenzii cd.*/
    
    public void execute (ArrayList<HeadFolder> h, int [] v, ArrayList<root> s,
        BufferedWriter wr,ArrayList<root> cdKeeper,String[] tok,
         BufferedWriter err) throws IOException {
        
        wr.write(Integer.toString(v[0]));
        wr.newLine();
        err.write(Integer.toString(v[1]));
        err.newLine();
        cdKeeper.clear();
        for (int i = 0; i < s.size(); i++) {
            cdKeeper.add(s.get(i));
        }
    }
}
