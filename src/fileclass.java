import java.io.File;
import java.io.*;
import java.util.*;
import java.awt.*;
public class fileclass {
    public static String[] getListofFiles(String path) {
        File folder = new File(path);


        return folder.list();

    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(getListofFiles("C:\\Users\\Domin\\Downloads")));
    }
    public static void open(String pfad){

        File file = new File(pfad);
        if (file.isDirectory()){return;}
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}



