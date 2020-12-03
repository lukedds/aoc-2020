package day3;

import helpers.Helpers;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DayThree {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> input = Helpers.getInputAsStrings("day3");

        part1();
        part2();
    }

    private static void part1() throws FileNotFoundException {
        int count = traverseSlope(1,3);
        System.out.println("Part1: " + count);
    }

    private static void part2() throws FileNotFoundException {

        final int total = (traverseSlope(1,1)*
        traverseSlope(3,1)*
        traverseSlope(5,1)*
        traverseSlope(7,1)*
        traverseSlope(1,2));

        System.out.println("Part2: " + total);
    }

    private static int traverseSlope(final int xMovement, final int yMovement) throws FileNotFoundException {

        ArrayList<String> input = Helpers.getInputAsStrings("day3");

        int x = 0;
        int y = 0;
        int count = 0;
        int length = input.get(0).length();
        while (y < input.size()) {
            if (input.get(y).charAt(x) == '#') {
                count +=1;
            }
            x = (x+xMovement)%length;
            y += yMovement;
        }
        return count;
    }
}
