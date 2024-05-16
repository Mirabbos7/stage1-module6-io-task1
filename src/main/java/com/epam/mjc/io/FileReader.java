package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;

public class FileReader {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        fileReader.getDataFromFile(new File("src/main/resources/Profile.txt"));
    }

    public Profile getDataFromFile(File file) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader("src/main/resources/Profile.txt"));) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Profile();
    }
}
