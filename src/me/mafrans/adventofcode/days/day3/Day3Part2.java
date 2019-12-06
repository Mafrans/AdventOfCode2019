package me.mafrans.adventofcode.days.day3;

import me.mafrans.adventofcode.FUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Day3Part2 {
    public static void main(String[] args) throws IOException {
        String[] input = FUtil.readResource("input/day3.dat");

        String[] wire1 = input[0].split(",");
        String[] wire2 = input[1].split(",");

        Set<GridValue2> grid = makeGrid(wire1, wire2);

        GridValue2 closest = new GridValue2(0, 0, 3, 999999);
        for(GridValue2 grv : grid) {
            int id = grv.val1;
            if(id == 3) {
                if(grv.val2 < closest.val2) {
                    closest = grv;
                }
            }
        }

        System.out.println("Closest distance: " + closest + " at " + closest.val2);
    }

    public static int manhattan(GridValue grv) {
        return Math.abs(grv.x) + Math.abs(grv.y);
    }

    public static Set<GridValue2> makeGrid(String[] wire1, String[] wire2) {
        Set<GridValue2> grid = new HashSet<>();

        int curX = 0;
        int curY = 0;
        int steps = 1;
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

                GridValue2 val = new GridValue2(curX, curY, 1, steps);
                if(!grid.contains(val)) {
                    grid.add(val);
                }
                steps++;
            }
        }

        System.out.println("----");
        curX = 0;
        curY = 0;
        steps = 1;
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

                GridValue2 oldVal = new GridValue2(curX, curY, 1, 0);
                System.out.println("1!");
                if(grid.contains(oldVal)) {
                    System.out.println("2!");
                    Set<GridValue2> old = (Set<GridValue2>) ((HashSet<GridValue2>) grid).clone();

                    for(GridValue2 grv : old) {
                        if(grv.equals(oldVal)) {
                            System.out.println("WOW!");
                            grid.remove(oldVal);
                            grid.add(new GridValue2(curX, curY, 3, grv.val2 + steps));
                        }
                    }
                }
                steps++;
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
