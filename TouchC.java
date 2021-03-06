import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author kuiper
 * Comada touch creeaza un nou 
 * fisier si il adauga in sistemul de fisiere/foldere.
 * Aceasta clasa implementeaza interfata Command.
 */
public class TouchC implements Command{
    private String name;
    
    public TouchC (String name) {
        this.name = name;
    }
    
    /* Executia comenzii. */
    public void execute (ArrayList<HeadFolder> h, int [] v, ArrayList<root> s,
         BufferedWriter wr,ArrayList<root> cdKeeper,String[] tok,
         BufferedWriter err) throws IOException {
        
        int ok = 0;
        int i = 0;
        int idx = 0;
        int cnt = 0;
        wr.write(Integer.toString(v[0]));
        wr.newLine();
        err.write(Integer.toString(v[1]));
        err.newLine();
        for ( i = 1; i < s.size(); i++) {
            ok = 0;
            for (int j = 0; j < h.size();j++) {
                if (s.get(1).getName().equals(h.get(j).getName())) {
                  idx = j;  
                  ok = 1;
                }
        }
            if (ok == 1) {
               
                for (int k = 2; k < s.size(); k++) {
                    String anterior = "";
                    String anterior_2 = "..";
                    for (int p = 1; p < k ; p++){
                        anterior += "/";
                        anterior += s.get(p).getName();
                        
                    }
                    h.get(idx).addFolder_File(s.get(k),anterior,anterior_2);
                }
            }
            if (ok == 0) {
                cnt = 0;
                idx = 0;
                HeadFolder newHead = new HeadFolder(s.get(i).getName());
                for(int j = 0; j < h.size(); j++){
                    if (newHead.getName().compareTo(h.get(j).getName()) < 0) {
                    idx = j;
                    cnt = 1;
                    break;
                }
                
            }
            if (cnt == 0) {
                h.add(newHead);
            }
            else  {
                h.add(idx,newHead);
            }
            }
        
    }
}
}
