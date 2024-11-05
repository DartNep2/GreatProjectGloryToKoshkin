package org.example;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import static org.example.Main.pathFinder;
public class DBOperator {
    public void readRules() {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(pathFinder+"\\textFiles\\rules.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public int GetRandom(int origin,int bound){
        Random rand = new Random();
        return rand.nextInt(origin,bound);
    }
    public String GetDatName () {
        int randomN = GetRandom(0, 100001);
        try {
            return Files.readAllLines(Paths.get(pathFinder + "\\textFiles\\names.txt"))
                    .get((randomN / 1000) - 1) + " " +
                    Files.readAllLines(Paths.get(pathFinder + "\\textFiles\\names.txt"))
                            .get(((randomN / 1000) - 1) / 2 + 1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}