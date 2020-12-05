package day5;

import helpers.Helpers;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.IntStream;

public class DayFive {

    public static void main(String[] args) throws FileNotFoundException {
        List<String> input = Helpers.getInputAsStrings("day5");
        part1(input);
        part2(input);
    }

    private static void part1(final List<String> input) {

        List<Integer> seats = getSeatNumbers(input);

        System.out.println("Part1: " + Collections.max(seats));

    }

    private static void part2(final List<String> input) {

        List<Integer> seats = getSeatNumbers(input);

        Integer mySeat = IntStream.range(
                Collections.min(seats), Collections.max(seats) +1).
                filter(e -> !seats.contains(e)).findFirst().getAsInt();

        System.out.println("Part 2: " + mySeat);
    }

    private static List<Integer> getSeatNumbers(List<String> input) {
        List<Integer> seats = new ArrayList<>();

        for (String i:input) {
            seats.add((getRow(getBinaryFromString(i))*8)+getColumn(getBinaryFromString(i)));
        }
        return seats;
    }

    private static int getRow(final String input) {
        return Integer.parseInt(input.substring(0,7), 2);
    }

    private static int getColumn(final String input) {
        return Integer.parseInt(input.substring(7,10), 2);
    }

    private static String getBinaryFromString(final String input) {

        return input.replaceAll("F", "0")
                .replaceAll("B","1")
                .replaceAll("L", "0")
                .replaceAll("R", "1");
    }
}
