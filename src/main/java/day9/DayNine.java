package day9;

import helpers.Helpers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class DayNine {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Part 1: " + part1(Helpers.getInputAsLongs("day9")));
        System.out.println("Part 2: " + part2(Helpers.getInputAsLongs("day9")));
    }

    private static Long part1(final ArrayList<Long> input) {

        for (int i = 25; i < input.size(); i++) {
            boolean found = false;
            Long currentNum = input.get(i);

            ArrayList<Long> subList = new ArrayList<>(input.subList(i - 25, i));
            for (Long j : subList) {
                for (Long k: subList) {
                    if (j + k == currentNum) {
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                return currentNum;
            }
        }
        return 0L;
    }

    private static Long part2(final ArrayList<Long> input) {

        Long targetNum = part1(input);

        for (Long i : input) {
            Long sum = i;
            ArrayList<Long> subList = new ArrayList<>(input.subList(input.indexOf(i) + 1, input.size()));
            for (Long j: subList) {
                if ((sum + j) == targetNum) {
                    ArrayList<Long> range = new ArrayList<>(input.subList(input.indexOf(i), input.indexOf(j) + 1));
                    return (Collections.min(range) + Collections.max(range));
                }
                sum += j;

            }

        }
        return 0L;
    }
}
