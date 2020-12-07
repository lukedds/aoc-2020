package day7;

import helpers.Helpers;

import java.io.FileNotFoundException;
import java.util.*;

public class DaySeven {

    public static void main(String[] args) throws FileNotFoundException {
        List<String> input = Helpers.getInputAsStrings("day7");
        System.out.println("Part 1: " + getNumberOfBagsWhichCanContain(input, "shiny gold"));
        System.out.println("Part 2: " + getTotalNumberOfBagsNeeded(input, "shiny gold"));
    }

    public static int getTotalNumberOfBagsNeeded(final List<String> input, final String bag) {
        Map<String, Map<String, Integer>> rules = getRules(input);

        return countInnerBags(bag, rules);
    }


    public static int countInnerBags(String bag, Map<String, Map<String, Integer>> rules) {
        int total = 0;

        for (Map.Entry<String,Integer> e : rules.get(bag).entrySet()) {
            if (e.getKey().equals("no other bag")) {
                continue;
            }
            total += e.getValue() + (countInnerBags(e.getKey(), rules) * e.getValue());
        }

        return total;
    }

    public static int getNumberOfBagsWhichCanContain(final List<String> input, final String bag) {

        int bagCount = 0;
        Map<String, Map<String, Integer>> rules = getRules(input);


        for (Map.Entry<String, Map<String, Integer>> i: rules.entrySet()) {

            if (findInnerBags(i.getValue(), bag, rules)) {
                bagCount +=1;
            }
        }
        return bagCount;
    }

    public static boolean findInnerBags(Map<String,Integer> bag, String expectedBag, Map<String, Map<String, Integer>> rules) {

        if (bag.containsKey(expectedBag)){
            return true;
        } else if (bag.containsKey("no other bag")) {
            return false;
        }
        for (Map.Entry<String, Integer> entry: bag.entrySet()) {
           if (findInnerBags(rules.get(entry.getKey()), expectedBag, rules)) {
               return true;
           }
        }
            return false;
        }


    private static Map<String, Map<String, Integer>> getRules(final List<String> input) {

        Map<String, Map<String, Integer>> rules = new HashMap<>();

        for (String i:input) {
            Map<String, Integer> bagRulesMap = new HashMap<>();
            i = i.replaceAll("bags", "bag").replaceAll(",", "").replaceAll("[.]", "");
            String bag = i.split("contain")[0];
            String bagRules = i.split("contain")[1];
            if (bagRules.trim().equals("no other bag")) {
                bagRulesMap.put("no other bag", 0);
                rules.put(bag.replaceAll("bag", "").trim(), bagRulesMap);
                continue;
            }
            List<String> bagRulesList = Arrays.asList(bagRules.split("bag"));

            for (String j: bagRulesList) {
                Map<Integer,String> thisRule = new HashMap<>();
                Integer number = Integer.parseInt(j.replaceAll("\\D+",""));
                String bagForRule = j.replaceAll("\\d+","").trim();
                bagRulesMap.put(bagForRule, number);
            }
            rules.put(bag.replaceAll("bag", "").trim(), bagRulesMap);
        }

        return rules;
    }
}
