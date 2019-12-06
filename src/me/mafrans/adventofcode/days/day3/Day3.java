package me.mafrans.adventofcode.days.day3;

import me.mafrans.adventofcode.FUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Day3 {
    public static void main(String[] args) throws IOException {
        String[] input = FUtil.readResource("input/day3.dat");

        String[] wire1 = input[0].split(",");
        String[] wire2 = input[1].split(",");

        Set<GridValue> grid = makeGrid(wire1, wire2);

        GridValue closest = new GridValue(999999, 999999, 3);
        for(GridValue grv : grid) {
            int val = (int)grv.val;
            if(val == 3) {
                int distance = manhattan(grv);

                if(distance < manhattan(closest)) {
                    closest = grv;
                }
            }
        }

        System.out.println("Closest distance: " + closest + " at " + manhattan(closest));
    }

    public static int manhattan(GridValue grv) {
        return Math.abs(grv.x) + Math.abs(grv.y);
    }

    public static Set<GridValue> makeGrid(String[] wire1, String[] wire2) {
        Set<GridValue> grid = new HashSet<>();

        int curX = 0;
        int curY = 0;
        for(String w : wire1) {
            String dir = w.substring(0, 1);
            int len = Integer.parseInt(w.substring(1));


            for(int i = 0; i < len; i++) {
                switch (dir) {
                    case "U":
                        curY -= 1;
                        break;
                    case "D":
                        curY += 1;
                        break;
                    case "L":
                        curX -= 1;
                        break;
                    case "R":
                        curX += 1;
                        break;
                }

                GridValue val = new GridValue(curX, curY, 1);
                grid.add(val);
            }
        }

        System.out.println("----");
        curX = 0;
        curY = 0;
        for(String w : wire2) {
            String dir = w.substring(0, 1);
            int len = Integer.parseInt(w.substring(1));

            for(int i = 0; i < len; i++) {
                switch (dir) {
                    case "U":
                        curY -= 1;
                        break;
                    case "D":
                        curY += 1;
                        break;
                    case "L":
                        curX -= 1;
                        break;
                    case "R":
                        curX += 1;
                        break;
                }

                GridValue oldVal = new GridValue(curX, curY, 1);
                GridValue val = new GridValue(curX, curY, 2);
                if(grid.contains(oldVal)) {
                    grid.remove(oldVal);
                    grid.add(new GridValue(val.x, val.y, 3));
                }
            }
        }

        return grid;
    }

    public static int[] gridSize(String[] wire1, String[] wire2) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;

        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        int curX = 0;
        int curY = 0;
        for(String w : wire1) {
            String dir = w.substring(0, 1);
            int len = Integer.parseInt(w.substring(1));

            System.out.println(dir);

            switch(dir) {
                case "U":
                    curY -= len;
                    break;
                case "D":
                    curY += len;
                    break;
                case "L":
                    curX -= len;
                    break;
                case "R":
                    curX += len;
                    break;
            }

            System.out.println(curX + ", " + curY);

            if(curX < minX) minX = curX;
            if(curX > maxX) maxX = curX;

            if(curY < minY) minY = curY;
            if(curY > maxY) maxY = curY;
        }

        curX = 0;
        curY = 0;
        for(String w : wire2) {
            String dir = w.substring(0, 1);
            int len = Integer.parseInt(w.substring(1));

            System.out.println(dir);

            switch(dir) {
                case "U":
                    curY -= len;
                    break;
                case "D":
                    curY += len;
                    break;
                case "L":
                    curX -= len;
                    break;
                case "R":
                    curX += len;
                    break;
            }

            System.out.println(curX + ", " + curY);

            if(curX < minX) minX = curX;
            if(curX > maxX) maxX = curX;

            if(curY < minY) minY = curY;
            if(curY > maxY) maxY = curY;
        }

        System.out.println(Arrays.toString(new int[] {minX, maxX, minY, maxY}));

        return new int[] {minX, maxX, minY, maxY};
    }
}
