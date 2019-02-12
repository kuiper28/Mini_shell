import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author kuiper
 * In aceasta clasa se 
 * realizeaza parsarea elementelor din
 * fisier.
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        commandInvoker cmd = new commandInvoker("");
        int [] commandNumber = new int[10];    
        commandNumber[0] = 1; // Numarul comenzii curente.
        commandNumber[1] = 1; // Numatul comenzii pentru erori.
        ArrayList<HeadFolder> system = new ArrayList<HeadFolder>();/* Sistemul
        de fisiere de baza.*/
        
        try {
        FileInputStream fstream = new FileInputStream(args[0]);
            try (DataInputStream in = new DataInputStream(fstream)) {
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
                BufferedWriter err = new BufferedWriter(new FileWriter(args[2]));
                String strLine;
                strLine = br.readLine();
                String [] tok;
                CommandBuilder build = new CommandBuilder ();
                ArrayList<root> v = new ArrayList<root>(); /* In v este retinuta
                calea data ca parametru unei anumite comenzi*/
                
                ArrayList<root> cdKeeper = new ArrayList();
                tok = strLine.split(" ");
                build.buildCommand(cmd, system, commandNumber, v,
                        writer, cdKeeper, tok, err);            
                while ((strLine = br.readLine()) != null) {
                   ArrayList<root> v_2 = new ArrayList<root>();
                   tok = strLine.split(" ");
                   build.buildCommand(cmd, system, commandNumber, v_2,
                        writer, cdKeeper, tok, err);                  
                }                
                writer.close();
                err.close();
    }    
} catch (IOException e){
         System.err.println("Error: " + e.getMessage());
       }
    }     
}
