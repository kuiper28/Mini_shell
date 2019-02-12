/**
 *
 * @author kuiper
 * In aceasta clasa se realizeaza instantierea 
 * unei comenzi prin intermediul metodei
 * createCommand din CommandFactory.
 */
public class commandReciver {
    String name;
    Command command;
    CommandFactory factory = new CommandFactory();
    public commandReciver (String name) {
        this.name = name;
        command = factory.createCommand (name);
    }
    
    public Command getCmd () {
        return this.command;
    } 
    
}
