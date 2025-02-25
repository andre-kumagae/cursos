package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        File file2 = new File("C:\\Users\\Andre\\git-codes\\cursos\\youtube\\dev-dojo\\maratona-java\\arquivo\\file2.txt");
        try {
//            boolean newFile = file.createNewFile();
            boolean newFile1 = file.createNewFile();
            String path = file.getPath();
            System.out.println("path = " + path);
            String absolutePath = file.getAbsolutePath();
            System.out.println("absolutePath = " + absolutePath);
            System.out.println("isDirectiory: "+file.isDirectory());
            System.out.println("isFile: "+file.isFile());
            System.out.println("isHidden: "+file.isHidden());
            System.out.println(new Date(file.lastModified()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (file.exists()) {
            boolean delete = file.delete();
            boolean delete2 = file2.delete();
        }
    }
}
