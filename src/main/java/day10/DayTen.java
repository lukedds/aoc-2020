package day10;

import helpers.Helpers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Handler;

public class DayTen {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> day10 = Helpers.getInputAsIntegers("day10");
        Collections.sort(day10);
        part1(day10);
        part2(day10);
    }

    public static void part1(ArrayList<Integer> input) {
        ArrayList<Integer> onesAndThrees = getOnesAndThrees(input);
        int calc = Collections.frequency(onesAndThrees, 1) * (Collections.frequency(onesAndThrees, 3) + 1);
        System.out.println("Part1: " + calc);
    }

    public static ArrayList<Long> getListOfGroupingsOfOnes(ArrayList<Integer> input) {

        ArrayList<Integer> onesAndThrees = getOnesAndThrees(input);
        ArrayList<Long> onesGroupings = new ArrayList<>();
        long count = 0L;

        for (Integer i : onesAndThrees) {
            if (i == 1) {
                count +=1;
            } else if (count != 0){
                onesGroupings.add(count);
                count = 0L;
            }
        }
        return onesGroupings;
    }

    public static void part2(ArrayList<Integer> input) {
        System.out.println("Part2: " + getNumberOfCombinations(input));
    }

    public static Long getNumberOfCombinations(ArrayList<Integer> input) {

        ArrayList<Long> permutations = getPermutations(input);
        return permutations.stream().reduce(1L, (a, b) -> a * b);
    }

    public static ArrayList<Long> getPermutations(ArrayList<Integer> input) {

        ArrayList<Long> groupings = getListOfGroupingsOfOnes(input);
        Collections.replaceAll(groupings, 4L, 7L);
        Collections.replaceAll(groupings, 3L, 4L);
        return groupings;
    }

    public static ArrayList<Integer> getOnesAndThrees(ArrayList<Integer> input) {
        int prev = 0;
        ArrayList<Integer> onesAndThrees = new ArrayList<>();
        for (Integer i : input) {
            if ((i-prev)==1) {
                onesAndThrees.add(1);
            } else if ((i-prev)==3) {
                onesAndThrees.add(3);
            }
            prev = i;
        }
        onesAndThrees.add(3);
        return onesAndThrees;
    }
}
