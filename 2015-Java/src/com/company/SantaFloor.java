package com.company;

import java.io.*;

public class SantaFloor {
    public static void main(String[] args) throws Exception {
        int floor = 1;

        BufferedReader in = new BufferedReader(new FileReader("parens.txt"));
        String line = in.readLine();

        for(int i = 0; i < line.length(); ++i) {
            char c = line.charAt(i);

            if(c == ')') {
                --floor;
            }
            else {
                ++floor;
            }

            if(floor == -1) {
                System.out.println("Basement: " + i);
                break;
            }
        }

        System.out.println("Floor = " + floor);
    }
}