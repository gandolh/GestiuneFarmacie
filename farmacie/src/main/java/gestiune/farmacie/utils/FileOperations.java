package gestiune.farmacie.utils;

import java.io.File;

public class FileOperations {
    public static void showFilesAtPath(String path){
        File file = new File(path);
        for(String fileNames : file.list()) System.out.println(fileNames);
    }

}
