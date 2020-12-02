package day1;

import helpers.Helpers;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DayOne {

    public static void main(String[] args) throws FileNotFoundException {
        final ArrayList<Integer> input = Helpers.getInputAsIntegers("day1");

        part1(input);
        part2(input);

    }

    private static void part1(final ArrayList<Integer> input) {
        for (Integer i: input) {
            if (input.contains(2020 - i)) {
                System.out.println("PART1:" + i*(2020-i));
                break;
            }
        }
    }

    private static void part2(final ArrayList<Integer> input) {

        outerLoop:
        for (Integer i: input) {
            for (Integer j: input) {
                if (input.contains(2020 - i - j)) {
                    System.out.println("PART2:" + i * j * (2020 - i - j));
                    break outerLoop;
                }
            }
        }
    }
}
