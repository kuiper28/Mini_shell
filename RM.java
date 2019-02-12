import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author kuiper
 */
public class RM implements Command{
    private String name;
    
    public RM (String name) {
        this.name = name;
    }
    
      public void execute (ArrayList<HeadFolder> h, int [] v, ArrayList<root> s,
            BufferedWriter wr,ArrayList<root> cdKeeper,String[] tok,
            BufferedWriter err)throws IOException {
          
        wr.write(Integer.toString(v[0]));
        wr.newLine();
        err.write(Integer.toString(v[1]));
        err.newLine();
        
        int found = 0;
        
        /* Caut un folder in sistemul de foldere/fisiere de baza si il sterg */
        for (int i = 0; i < h.size(); i++) {
	  if (s.size() >= 2)	
            if (h.get(i).getName().equals(s.get(1).getName())) {
                h.remove(i);
            }
        }
      }
}
