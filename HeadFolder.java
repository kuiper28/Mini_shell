import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author kuiper
 * 
 * O instanta a clasei HeadFolder
 * este considerata radacina sistemului
 * de fisere(foldere).
 * 
 */
public class HeadFolder {    
    private String name;
    private ArrayList <root> file_folder_system;
    private ArrayList <String> anterior; /* retine locul in care un folder sau
    fisier se afla in mod unic */
    
    private ArrayList <String> sortedAnterior; /* retine locul in care un folder
    sau */
    private ArrayList <String> Ant;
    
    public HeadFolder (String name) {
        this.name = name;
        this.file_folder_system = new ArrayList<> ();
        this.anterior = new ArrayList<> ();
        this.sortedAnterior = new ArrayList<> ();
        this.Ant = new ArrayList<> ();
    } 

    /*
        Metoda care adauga un nou folder sau fisier in
        sistemul de foldere/fisiere.
    */
    public void addFolder_File (root f,String ant, String ant2) {
        int ok = 0;
        int cnt = 0;
        int idx = 0;
        for (int i = 0 ;i < file_folder_system.size(); i++) {
            if (f.getName().equals(file_folder_system.get(i).getName()))
                ok = 1;
        
        }
        if (ok == 0) {
            cnt = 0;
            for(int i = 0; i < file_folder_system.size(); i++){
                if (f.getName().compareTo(file_folder_system.get(i).getName()) < 0) {
                idx = i;
                cnt = 1;
                break;
                }
                
            }
            if (cnt == 0) {
                file_folder_system.add(f);
                anterior.add(ant);
            }
            else  {
                file_folder_system.add(idx,f);
                anterior.add(idx,ant);
            }
            sortedAnterior.add(ant);
            Ant.add(ant2);
        }
    }
    public void sortAnt () {
        Collections.sort(this.sortedAnterior);
        Collections.sort(this.Ant);
        for (int i = 1 ;i < sortedAnterior.size();i++) {
             if (sortedAnterior.get(i-1).equals(sortedAnterior.get(i)))
                 sortedAnterior.remove(i-1);
        }
        for (int i = 0; i < sortedAnterior.size(); i++) {
            for (int j = i + 1; j < sortedAnterior.size(); j++) {
                if (sortedAnterior.get(i).equals(sortedAnterior.get(j))) {
                    sortedAnterior.remove(i);
                    
        }
        }
    }
    }
    
    /* Intoarce numele folder-ului/fisierului de pe pozitia i*/
    public String getiName (int i) {
        for (int j = 0; j < file_folder_system.size();j++) {
            if (i == j) {
                return file_folder_system.get(i).getName();
            }
        }
        return "0";
    }
    
    
    public List getFileSystem () {
        return this.file_folder_system;
    }   
    public List getAnterior () {
        return this.anterior;
    }
    public List getAnt () {
        return this.Ant;
    }
    public List getSAnterior () {
        return this.sortedAnterior;
    }
    public String getName () {
        return this.name;
    }
}
