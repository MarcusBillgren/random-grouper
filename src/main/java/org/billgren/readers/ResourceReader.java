package org.billgren.readers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ResourceReader {

    public static List<String> generateArrayListFromFile(String filename) throws IOException {

        return Files.readAllLines(Paths.get(filename));
    }
}
