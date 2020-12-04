package day4;

import helpers.Helpers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class DayFour {

    private static final List<String> expectedElements = Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");

    public static void main(final String[] args) throws IOException {

        List<String> documents = Arrays.asList(Helpers.getInputAsString("day4").split("\n\n"));
        part1(documents);
        part2(documents);
    }

    private static void part1(final List<String> documentList) {
        System.out.println("Part1: " + getPassportsWithAllElementsAsMaps(documentList).size());
    }

    private static void part2(final List<String> documentList) {
       System.out.println("Part2: " + countValidPassports(documentList));
    }

    private static int countValidPassports(List<String> documents) {
        ArrayList<HashMap<String, String>> passportsWithAllElementsAsMaps = getPassportsWithAllElementsAsMaps(documents);

        int count = 0;

        for (HashMap<String,String> passport: passportsWithAllElementsAsMaps) {
            if (passportIsValid(passport)) {
                count += 1;
            }
        }
        return count;
    }

    private static boolean passportIsValid(final HashMap<String,String> passport) {

        return expectedElements.stream().allMatch(
                e -> Pattern.compile(getRegexForElement(e)).matcher(passport.get(e)).matches()
        );
    }

    private static String getRegexForElement(final String element) {
        HashMap<String,String> regExValues = new HashMap<String,String>();

        regExValues.put("byr","(19[2-9][0-9]|200[0-2])");
        regExValues.put("iyr","(201[0-9]|2020)");
        regExValues.put("eyr","(202[0-9]|2030)");
        regExValues.put("hgt","(1[5-8][0-9]|19[0-3])cm|(59|6[0-9]|7[0-6])in");
        regExValues.put("hcl","#[0-9a-f]{6}");
        regExValues.put("ecl","(amb|blu|brn|gry|grn|hzl|oth)");
        regExValues.put("pid","[0-9]{9}");

        return regExValues.get(element);
    }

    private static boolean documentHasRequiredElements(final String document) {
        return expectedElements.stream().allMatch(document::contains);
    }

    private static ArrayList<HashMap<String, String>> getPassportsWithAllElementsAsMaps(final List<String> passports) {

        final ArrayList<HashMap<String, String>> list = new ArrayList<>();

        for (String passport:passports) {
            if (documentHasRequiredElements(passport)) {
                final HashMap<String, String> map = new HashMap<String, String>();
                for (String pair : passport.replace("\n", " ").split(" ")) {
                    String[] kvPair = pair.split(":");
                    map.put(kvPair[0], kvPair[1]);
                }
                list.add(map);
            }
        }

        return list;
    }
}
