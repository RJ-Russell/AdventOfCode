package com.company;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by chupacabra on 12/11/15.
 */
public class NaughtyNice {
    static int naughty = 0;
    static int nice = 0;

    public static void main(String[] args) throws Exception {
        String line;

        BufferedReader in = new BufferedReader(new FileReader("naughtynice.txt"));

        while ((line = in.readLine()) != null) {
            if (findVowels(line) && twoInRow(line) && doesNotContain(line)) {
                ++nice;
            } else {
                ++naughty;
            }
        }
        System.out.println("NICE: " + nice);
        System.out.println("NAUGHTY: " + naughty);
    }

    public static boolean findVowels(String line) {
        int numVowels = 0;
        for (int i = 0; i < line.length(); ++i) {
            switch (line.charAt(i)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    ++numVowels;
            }
        }
        return numVowels >= 3;
    }

    public static boolean twoInRow(String line) {
        for (int i = 0; i < line.length() - 1; ++i) {
            if (line.charAt(i) == line.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean doesNotContain(String line) {
        return !(line.contains("ab") || line.contains("cd") || line.contains("pq") || line.contains("xy"));
    }
}