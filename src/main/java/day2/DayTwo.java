package day2;

import helpers.Helpers;
import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DayTwo {


    public static void main(String[] args) throws FileNotFoundException {
        final ArrayList<String> input = Helpers.getInputAsStrings("day2");
        part1(input);
        part2(input);
    }

    private static void part1(final ArrayList<String> input) {
        int count = 0;

        for (String i:input) {

            Password password = new Password(i);

            int occurrences = StringUtils.countMatches(password.getPassword(), password.getLetter());

            if ( (occurrences >= password.getDigit1()) && (occurrences <= password.getDigit2())) {
                count += 1;
            }
        }
        System.out.println("Part 1 Count: " + count);
    }

    private static void part2(final ArrayList<String> input) {
        int count = 0;

        for (String i:input) {

            Password password = new Password(i);

            String letterAtFirstPosition = String.valueOf(password.getPassword().charAt(password.getDigit1() - 1));
            String letterAtSecondPosition = String.valueOf(password.getPassword().charAt(password.getDigit2() - 1));

            if (letterAtFirstPosition.equals(password.getLetter()) ^ letterAtSecondPosition.equals(password.getLetter())) {
                count += 1;
            }
        }
        System.out.println("Part 2 Count: " + count);
    }

}
