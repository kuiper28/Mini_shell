import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author kuiper
 * In acesta clasa se realizeaza
 * "invocarea" metodei execute pentru
 * comada.
 */
public class commandInvoker {
    
     String name;
     commandReciver cmdI;
    
    public commandInvoker (String name) {
        this.name = name;
        cmdI = new commandReciver (this.name);
      
    }
    
    public void executeCmd (ArrayList<HeadFolder> h,int [] v,ArrayList<root> s,
            BufferedWriter wr,ArrayList<root> cdKeeper,String[] tok,
            BufferedWriter err) throws IOException {
        if (cmdI != null) {
        Command command = cmdI.getCmd ();
        command.execute (h, v, s, wr,cdKeeper,tok,err);
        }
    }
    
}
