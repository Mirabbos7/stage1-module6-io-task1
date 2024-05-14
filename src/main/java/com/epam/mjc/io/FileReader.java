package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;

public class FileReader {
    final private static String File_PATH = "src/main/resources/Profile.txt";
    public Profile getDataFromFile(File file) {
        try{
            BufferedReader reader = new BufferedReader(new java.io.FileReader(File_PATH));
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Profile();
    }
}
