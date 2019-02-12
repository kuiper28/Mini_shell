import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author kuiper
 * In aceasta clasa se realizeaza constructia 
 * comenzii care va fi folosita.
 */
public class CommandBuilder {    
    private String [] t;
    private String keep;
 
    public void buildCommand (commandInvoker cmd,ArrayList<HeadFolder> system,
            int [] commandNumber,ArrayList<root> s, BufferedWriter writer,
            ArrayList<root> cdKeeper,String []tok,BufferedWriter err) throws IOException {
                       
            if (tok[0].equals("pwd")) {
                       cmd = new commandInvoker("pwd");
                       cmd.executeCmd(system,commandNumber,s,writer, cdKeeper,tok,err);
                       commandNumber[0]++;
                       commandNumber[1]++;
               } else
                   if (tok[0].equals("cd")) {
                       if (tok[1].equals("/")) {
                        cmd = new commandInvoker("cd");
                        root f  = new Folder("/");
                        s.add(f);
                        cmd.executeCmd(system,commandNumber,s,writer, cdKeeper,tok,err); 
                        commandNumber[0]++;
                        commandNumber[1]++;
                       } else {
                           keep = tok[1];
                           t = keep.split("/");
                           for (int i = 1; i < t.length; i++) {
                               root f  = new Folder(t[i]);
                               s.add(f);
                               
                           }
                           cmd = new commandInvoker("cd");
                           cmd.executeCmd(system,commandNumber,s,writer, cdKeeper,tok,err); 
                           commandNumber[0]++;
                           commandNumber[1]++;
                       }
                   } else if (tok[0].equals("mkdir")) {
                       keep = tok[1];
                       t = keep.split("/");
                       for(int j = 0; j < t.length; j++) {
                           root f = new Folder(t[j]);
                           s.add(f);
                       }
                       cmd = new commandInvoker("mkdir");
                       cmd.executeCmd(system,commandNumber,s,writer, cdKeeper,tok,err);
                       commandNumber[0]++;
                       commandNumber[1]++;
                       s.clear();
                   } else if (tok[0].equals("ls")) {
                       if (tok.length == 1) {
                           root f = new Folder("");
                           s.add(f);                     
                       cmd = new commandInvoker("ls");
                       cmd.executeCmd(system,commandNumber,s,writer, cdKeeper,tok,err);
                       commandNumber[0]++;
                       commandNumber[1]++;
                       s.clear();
                       } else {
                       keep = tok[1];
                       t = keep.split("/");
                       for(int j = 0; j < t.length; j++) {
                           root f = new Folder(t[j]);
                           s.add(f);
                       }
                       cmd = new commandInvoker("ls");
                       cmd.executeCmd(system,commandNumber,s,writer, cdKeeper,tok,err);
                       commandNumber[0]++;
                       commandNumber[1]++;
                       s.clear();
                   }
                   } else if (tok[0].equals("ls") && tok[1].equals("-R")) {
                       cmd = new commandInvoker("ls -R");
                       cmd.executeCmd(system,commandNumber,s,writer,cdKeeper,tok,err);
                       commandNumber[0]++;
                       commandNumber[1]++;
                   } else if (tok[0].equals("touch")) {
                       keep = tok[1];
                       t = keep.split("/");
                       for(int j = 0; j < t.length; j++) {
                           root f = new Folder(t[j]);
                           s.add(f);
                       }
                       cmd = new commandInvoker("touch");
                       cmd.executeCmd(system,commandNumber,s,writer, cdKeeper,tok,err);
                       commandNumber[0]++;
                       commandNumber[1]++;
                       s.clear();
                   } else if (tok[0].equals("rm")) {
                       keep = tok[1];
                       t = keep.split("/");
                       for(int j = 0; j < t.length; j++) {
                           root f = new Folder(t[j]);
                           s.add(f);
                       }
                       cmd = new commandInvoker("rm");
                       cmd.executeCmd(system,commandNumber,s,writer, cdKeeper,tok,err);
                       commandNumber[0]++;
                       commandNumber[1]++;
                       s.clear();
                   } 
                } 
    }
