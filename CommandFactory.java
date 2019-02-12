/**
 *
 * @author kuiper
 */
public class CommandFactory {
        public Command createCommand (String type) {
        Command cmd = null;
        if (type.equals("pwd")) {
            cmd = new PWD("pwd");
        } else if (type.equals("cd")) {
            cmd = new CD("cd");
        } else if (type.equals("mkdir")) {
            cmd = new MKDIR("mkdir");
        } else if (type.equals("ls")) {
            cmd = new LS("ls");
        } else if (type.equals("touch")) {
            cmd = new TouchC("touch");
        } else if (type.equals("rm")) {
            cmd = new RM("rm");
        } 
        return cmd;
    }
}
