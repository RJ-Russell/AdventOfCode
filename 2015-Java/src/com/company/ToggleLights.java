package com.company;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by chupacabra on 12/11/15.
 */
public class ToggleLights {
    static final int square = 1000;
    static int[][] grid = new int[square][square];
    static int[] intStart = null;
    static int[] intStop = null;

    public static void main(String[] args) throws Exception {
        String line;
        String action = "";

        BufferedReader in = new BufferedReader((new FileReader("Text_Files/togglelights.txt")));

        while ((line = in.readLine()) != null) {
            String[] tokens = line.split(" ");
            String word = tokens[0];
            if (word.equalsIgnoreCase("toggle")) {
                String[] start = tokens[1].split(",");
                String[] stop = tokens[3].split(",");
                intStart = new int[]{Integer.parseInt(start[0]), Integer.parseInt(start[1])};
                intStop = new int[]{Integer.parseInt(stop[0]), Integer.parseInt(stop[1])};
            } else {
                action = tokens[1];
                String[] start = tokens[2].split(",");
                String[] stop = tokens[4].split(",");
                intStart = new int[]{Integer.parseInt(start[0]), Integer.parseInt(start[1])};
                intStop = new int[]{Integer.parseInt(stop[0]), Integer.parseInt(stop[1])};
            }

            if (word.equalsIgnoreCase("turn") && action.equalsIgnoreCase("on")) {
                turnOn(intStart, intStop);
            } else if (word.equalsIgnoreCase("turn") && action.equalsIgnoreCase("off")) {
                turnOff(intStart, intStop);
            } else if (word.equalsIgnoreCase("toggle")) {
                toggle(intStart, intStop);
            }
        }
        System.out.println("TOTAL BRIGHTNESS: " + calculateOn());
        // Part 1
        //System.out.println("TOTAL ON: " + calculateOn());
    }

    public static void turnOn(int[] start, int[] stop) {
        for (int i = start[0]; i <= stop[0]; ++i) {
            for (int j = start[1]; j <= stop[1]; ++j) {
                grid[i][j] += 1;
                // Part 1
                /* if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                } */
            }
        }
    }

    public static void turnOff(int[] start, int[] stop) {
        for (int i = start[0]; i <= stop[0]; ++i) {
            for (int j = start[1]; j <= stop[1]; ++j) {
                if(grid[i][j] > 0) {
                    grid[i][j] -= 1;
                }

                // Part 1
                /* if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                }
                */
            }
        }
    }

    public static void toggle(int[] start, int[] stop) {
        for (int i = start[0]; i <= stop[0]; ++i) {
            for (int j = start[1]; j <= stop[1]; ++j) {
                grid[i][j] += 2;

                // Part 1
                /* if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                } else if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                }
                */
            }
        }
    }

    public static int calculateOn() {
        int brightness = 0;
        for (int i = 0; i < square; ++i) {
            for (int j = 0; j < square; ++j) {
                brightness += grid[i][j];
            }
        }
        return brightness;
        // Part 1
        /* int on = 0;
        for (int i = 0; i < square; ++i) {
            for (int j = 0; j < square; ++j) {
                if (grid[i][j] == 1) {
                    ++on;
                }
            }
        }

        return on;
        */
    }
}
