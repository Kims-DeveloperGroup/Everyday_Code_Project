package com.company.sample.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by devoo-kim on 16. 10. 30.
 */
public class ListFilesInDirectory {

    public static void listFilesInDir() throws IOException {
        Path dir =Paths.get("resources/directory");
        Stream<Path> paths =Files.list(dir);
//        System.out.println("Number of entries: "+ paths.countStroke());

        paths.forEach(path -> {
            System.out.println("File: "+path.getParent());
        });
    }

    public static void main(String[] args) throws IOException {
        listFilesInDir();
    }
}
