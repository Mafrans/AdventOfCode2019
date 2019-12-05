package me.mafrans.adventofcode.days;

import me.mafrans.adventofcode.FUtil;

import java.io.IOException;
import java.util.Arrays;

public class Day1 {

    public static void main(String[] args) throws IOException {
        String[] input = FUtil.readResource("input/day1.dat");

        int sum = 0;
        for(String line : input) {
            int mass = Integer.parseInt(line);

            sum += Math.floor(mass / 3.) - 2;
        }

        System.out.println(sum);
    }
}
