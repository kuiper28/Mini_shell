import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author kuiper
 * Commanda ls, care face
 * listarea continutului sistemului
 * de fisiere/foldere in funcie de 
 * anumite argumente.
 */
public class LS implements Command{
    
    private String name;
    
    public LS (String name) {
        this.name = name;
    }
    public void execute (ArrayList<HeadFolder> h, int [] v, ArrayList<root> s,
        BufferedWriter wr,ArrayList<root> cdKeeper,String[] tok,
        BufferedWriter err) throws IOException {
        
        wr.write(Integer.toString(v[0]));
        wr.newLine();
        err.write(Integer.toString(v[1]));
        err.newLine();
        int count = 1;
        int ok = 0;
        ArrayList<Integer> idx = new ArrayList();
        
        // Cazul in care avem ls -R
        if (tok.length >= 2 && tok[1].equals("-R")) {

	// Cazul in care "ls -R" nu are argumente.
        if (tok.length == 2) {  
        wr.write("/:");
        wr.newLine();
        
        for (int i = 0; i < h.size(); i++) {
            h.get(i).sortAnt();
            if (ok == 0) {
            wr.write("/");
            wr.write(h.get(i).getName());
	    ok = 1;
        } else {
            wr.write(" " + "/" + h.get(i).getName());
            }
        }
        ok = 0;
        wr.newLine();
        wr.newLine();
        
        for (int i = 0; i < h.size(); i++) {
            for (int l = 0; l < h.get(i).getAnt().size(); l++) {
                for (int y = 0; y < h.get(i).getSAnterior().size(); y++) {
                if (h.get(i).getAnt().get(l).equals(h.get(i).getSAnterior().get(y)))
                    idx.add(l);
                    
            }
            }
            for (int k = 0; k < h.get(i).getSAnterior().size(); k++) {
                wr.write(h.get(i).getSAnterior().get(k) + ":");
                wr.newLine();
            for (int j = 0; j < h.get(i).getFileSystem().size(); j++) {
               if (h.get(i).getAnterior().get(j).equals(h.get(i).getSAnterior().get(k))) {
                   if (ok == 0) {
                   wr.write(h.get(i).getAnterior().get(j) + "/" +
                           h.get(i).getiName(j));
                   ok = 1;
                   } else {
                       wr.write(" " + h.get(i).getAnterior().get(j) + "/" +
                           h.get(i).getiName(j));
                   }
               }
            }
            ok = 0;
            wr.newLine();
            wr.newLine();
            for (int l = 0; l < h.get(i).getAnt().size(); l++) {
                    if (h.get(i).getAnt().get(l).equals(h.get(i).getSAnterior().get(k))) {
                        if (idx.size() > 1) {
                       for (int z = idx.get(0)+1; z < idx.get(1);z++) {
                           wr.write((String) h.get(i).getAnt().get(z) + ":");
                           wr.newLine();
                           wr.newLine();
                           wr.newLine();
                       }
                       count++;
                       idx.remove(0);
                    } else {
                        for (int z = idx.get(0)+1; z < h.get(i).getAnt().size();z++) { 
                           wr.write((String) h.get(i).getAnt().get(z) + ":");
                           wr.newLine();
                           wr.newLine();
                           wr.newLine();
                        }   
                        }
                            
                    }
            }
            }
            if (idx.size() == 0) {
             for (int l = 0; l < h.get(i).getAnt().size(); l++) {
                if (!((String) h.get(i).getAnt().get(l)).equals("..")) {
                    wr.write((String) h.get(i).getAnt().get(l) + ":");
                    wr.newLine();
                    wr.newLine();
                    wr.newLine();
                }
            }
            }
            if (h.get(i).getAnt().size() == 0) {
                wr.write("/" + h.get(i).getName() + ":");
                wr.newLine();
                wr.newLine();
                wr.newLine();
            }
            idx.clear();
        }
        } else {
            idx.clear();
            int index = 0;
            ok = 0;
            String[] t = tok[2].split("/");
            wr.write(tok[2] + ":");
            wr.newLine();
            if (t.length >= 2) {
            for (int l = 0; l < h.size(); l++) {
                if (h.get(l).getName().equals(t[1]));
                    index = l;
            }
            for (int j = 0; j < h.get(index).getFileSystem().size(); j++) {
                if (h.get(index).getAnterior().get(j).equals(tok[2])) {
                    if (ok == 0) {
                    wr.write(tok[2] + "/" + h.get(index).getiName(j));
                    ok = 1;
                    } else {
                        wr.write(" " + tok[2] + "/" + h.get(index).getiName(j));
                    }                  
                }
            }
            wr.newLine();
            wr.newLine();
            for (int j = 0; j < h.get(index).getFileSystem().size(); j++) {
                if (h.get(index).getAnterior().get(j).equals(tok[2])) {
                    wr.write(tok[2] + "/" + h.get(index).getiName(j) + ":"); 
                    wr.newLine();
                    wr.newLine();
                    wr.newLine();
            }   
        }
        } else {
	    ok = 0;
        for (int i = 0; i < h.size(); i++) {
            h.get(i).sortAnt();
            if (ok == 0) {
            wr.write("/");
            wr.write(h.get(i).getName());
            ok = 1;
	    } else {
		wr.write(" " + "/" + h.get(i).getName());		
	}
	
        }
	ok = 0;
        wr.newLine();
        wr.newLine();
        
        for (int i = 0; i < h.size(); i++) {
            for (int l = 0; l < h.get(i).getAnt().size(); l++) {
                for (int y = 0; y < h.get(i).getSAnterior().size(); y++) {
                if (h.get(i).getAnt().get(l).equals(h.get(i).getSAnterior().get(y)))
                    idx.add(l);
                    
            }
            }
            for (int k = 0; k < h.get(i).getSAnterior().size(); k++) {
                wr.write(h.get(i).getSAnterior().get(k) + ":");
                wr.newLine();
            for (int j = 0; j < h.get(i).getFileSystem().size(); j++) {
               if (h.get(i).getAnterior().get(j).equals(h.get(i).getSAnterior().get(k))) {
                   if (ok == 0) {
                   wr.write(h.get(i).getAnterior().get(j) + "/" +
                           h.get(i).getiName(j));
                   ok = 1;
                   } else {
                       wr.write(" " + h.get(i).getAnterior().get(j) + "/" +
                           h.get(i).getiName(j));
                   }
               }
            }
            ok = 0;
            wr.newLine();
            wr.newLine();
            for (int l = 0; l < h.get(i).getAnt().size(); l++) {
                if (!((String) h.get(i).getAnt().get(l)).equals("..")) {
                    wr.write((String) h.get(i).getAnt().get(l) + ":");
                    wr.newLine();
                    wr.newLine();
                    wr.newLine();
                }
            }
            }
        }
            }
        }
        } else // Cazul in care avem ls fara niciun argument.
        if (s.size() == 1) {
            ok = 0;
            wr.write("/:");
            wr.newLine();
            for (int i = 0; i < h.size();i++) {
                if (ok == 0) {
                wr.write("/");
                wr.write(h.get(i).getName());
		ok = 1;
	}
                else {
                    wr.write(" " + "/" + h.get(i).getName());
                }
            }
            wr.newLine();
            wr.newLine();
        } else if(s.size() >= 2) { // Cazul in care avem ls cu argumente.
            
            for (int j = 0; j < h.size(); j++)
                if(h.get(j).getName().equals(s.get(1).getName())){
            wr.write("/");
            wr.write(h.get(j).getName() + ":");
            wr.newLine();
            for(int i = 0; i < h.get(j).getFileSystem().size();i++){
             if (ok == 0) {   
                wr.write("/" + h.get(j).getName() + "/" + h.get(j).getiName(i));
                ok = 1;
             } else {
                wr.write(" " + "/" + h.get(j).getName() + "/" + h.get(j).getiName(i)); 
             }
            }
             wr.newLine();
             wr.newLine();
             ok = 0;
             
        }
        }
    }
}
