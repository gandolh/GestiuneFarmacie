package gestiune.farmacie.utils;

import java.io.File;

/**
 * Clasa pentru gestionarea operatiilor cu fisiere
 */
public class FileOperations {
    /**
     * Afisare toate fisierele de la o cale
     * @param path calea de la care sa se afiseze toate fisierele
     */
    public static void showFilesAtPath(String path){
        File file = new File(path);
        for(String fileNames : file.list()) System.out.println(fileNames);
    }

}
