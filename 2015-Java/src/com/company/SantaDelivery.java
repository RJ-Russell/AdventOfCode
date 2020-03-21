package com.company;

import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * Created by chupacabra on 12/11/15.
 */

public class SantaDelivery {
    public static int x = 0;
    public static int y = 0;

    public static void main(String[] args) throws Exception {
        int numPresents = 1;

        Map<Point,Object> santa = new HashMap<Point, Object>();
        Object value = new Object();
        Point key;

        BufferedReader in = new BufferedReader(new FileReader("directions.txt"));
        String line = in.readLine();
        for(int i = 0; i < line.length(); ++i) {
            char c = line.charAt(i);
            mapping(c);
            key = new Point(x,y);
            if(!santa.containsKey(key)) {
                ++numPresents;
                santa.put(key, value);
            }
        }
        System.out.println("Num presents: " + numPresents);
    }

    public static void mapping(char direction) {
        switch(direction) {
            case '^':
                x += 0;
                y += 1;
                break;
            case 'v':
                x += 0;
                y -= 1;
                break;
            case '>':
                x += 1;
                y += 0;
                break;
            case '<':
                x -= 1;
                y += 0;
                break;
        }
    }
}

