import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author kuiper
 * Comanda care realizeaza
 * printarea directorului curent.
 */
public class PWD implements Command {
    
    private String name;
    
    public PWD (String name) {
        this.name = name;
    }
    
    @Override
    public void execute (ArrayList<HeadFolder> h, int []v,ArrayList<root> s,
            BufferedWriter wr,ArrayList<root> cdKeeper,String[] tok,
            BufferedWriter err) throws IOException {
        
        wr.write(Integer.toString(v[0]));
        wr.newLine();
        err.write(Integer.toString(v[1]));
        err.newLine();
        int count = 1;
        
        /* In cdKeeper este retinut locul in care ma aflu la un moment dat.*/
        if (cdKeeper.size() == 0 || cdKeeper.size() == 1) {
            wr.write("/");
            wr.newLine();
        } else {
           wr.write("/");
            for (int i = 0; i < cdKeeper.size(); i++) {
               cdKeeper.get(i).printFolder(wr);
                count ++;
                if (count <= cdKeeper.size())
                    wr.write("/");
            }
	wr.newLine();
    }   
    }  
}
