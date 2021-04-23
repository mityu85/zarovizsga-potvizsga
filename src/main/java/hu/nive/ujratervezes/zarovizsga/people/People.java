package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class People {

    public int getNumberOfMales(String path) {
        int sum = 0;
        try (BufferedReader br = Files.newBufferedReader(Path.of(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(",Male,")) {
                    sum++;
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("File cannot read", e);
        }
        return sum;
    }
}
