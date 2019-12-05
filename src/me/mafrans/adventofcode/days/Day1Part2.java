package me.mafrans.adventofcode.days;

import me.mafrans.adventofcode.FUtil;

import java.io.IOException;

public class Day1Part2 {

    public static void main(String[] args) throws IOException {
        String[] input = FUtil.readResource("input/day1.dat");

        int sum = 0;
        for(String line : input) {
            int mass = Integer.parseInt(line);

            sum += calculateFuel(mass);
        }

        System.out.println(sum);
    }


    public static int fuel(int mass) {
        return (int) (Math.floor(mass / 3.) - 2);
    }

    public static int calculateFuel(int mass) {
        int sum = 0;
        int fuel = fuel(mass);
        while(fuel > 0) {
            sum += fuel;
            fuel = fuel(fuel);
        }

        return sum;
    }
}
