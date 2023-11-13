package org.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int needed = 1000000;
    static StringBuilder results = new StringBuilder();

    public static void main(String[] args) {
        while (needed <= 6700000) {
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            List<Integer> numbers = new ArrayList<>();
            results.append(needed).append(";");
            for (int i = 0; i < needed; i++) numbers.add(i);
            // Maximum
            long startTime = System.nanoTime();
            for (int j = 0; j < needed; j++) {
                if (numbers.get(j) > max) max = numbers.get(j);
            }
            long endTime = System.nanoTime();
            long spent_time = (endTime - startTime);  //divide by 1000000 to get milliseconds.
            results.append(spent_time / 1000000).append(",").append((spent_time / 10000) % 100).append(";");
            // Minimum
            startTime = System.nanoTime();
            for (int j = 0; j < needed; j++) {
                if (numbers.get(j) < min) min = numbers.get(j);
            }
            endTime = System.nanoTime();
            spent_time = (endTime - startTime);  //divide by 1000000 to get milliseconds.
            results.append(spent_time / 1000000).append(",").append((spent_time / 10000) % 100).append("\n");
            needed += 10000;
            File outputFile = new File("Results.txt");
            try (OutputStream outputStream = new FileOutputStream(outputFile)) {
                outputStream.write(results.toString().getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}