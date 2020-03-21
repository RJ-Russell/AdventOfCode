package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/**
 * Created by chupacabra on 12/10/15.
 */
public class WrapPaper {
    public static void main(String[] args) throws Exception {
        String line;
        int totalArea = 0;
        int ribbonLength = 0;
        BufferedReader in = new BufferedReader(new FileReader("dims.txt"));
        while((line = in.readLine()) != null) {
            String[] values = line.split("x");

            int length = Integer.parseInt(values[0]);
            int width = Integer.parseInt(values[1]);
            int height = Integer.parseInt(values[2]);
            totalArea += calculateSurfaceArea(length, width, height) + smallSideArea(length, width, height);
            ribbonLength += smallestPerimeter(length,width,height) + cubicVolume(length,width,height);
        }
        System.out.println("Total sqft needed: " + totalArea);
        System.out.println("Total ribbon needed: " + ribbonLength);
    }

    public static int calculateSurfaceArea(int l, int w, int h) {
        return ((2*l*w)+(2*w*h)+(2*h*l));
    }

    public static int smallSideArea(int l, int w, int h) {
        int[] values = new int[]{l,w,h};
        Arrays.sort(values);

        return (values[0] * values[1]);
    }

    public static int smallestPerimeter(int l, int w, int h) {
        int[] values = new int[]{l,w,h};
        Arrays.sort(values);
        return ((values[0]*2)+(values[1]*2));
    }

    public static int cubicVolume(int l, int w, int h) {
        return l*w*h;
    }
}
