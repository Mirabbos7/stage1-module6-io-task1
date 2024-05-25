package com.epam.mjc.io;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReader {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        Profile profile = fileReader.getDataFromFile(new File("src/main/resources/Profile.txt"));
        System.out.println(profile);
    }

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                if (parts.length == 2) {
                    String key = parts[0];
                    String value = parts[1];
                    switch (key) {
                        case "Name":
                            profile.setName(value);
                            break;
                        case "Age":
                            profile.setAge(Integer.parseInt(value));
                            break;
                        case "Email":
                            profile.setEmail(value);
                            break;
                        case "Phone":
                            profile.setPhone(Long.valueOf(value));
                            break;
                        default:
                            System.err.println("Unknown key: " + key);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Error parsing age: " + e.getMessage());
        }
        return profile;
    }
}
