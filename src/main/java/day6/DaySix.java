package day6;

import helpers.Helpers;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class DaySix {

    public static void main(String[] args) throws IOException {
        final List<String> answers = Arrays.asList(Helpers.getInputAsString("day6").split("\n\n"));

        part1(answers);
        part2(answers);
    }

    private static void part1(List<String> answers) {

       answers = answers.stream().map(e -> e.replaceAll("\n","")).collect(Collectors.toList());

       final int sum = lineToSet(answers).stream().mapToInt(Set::size).sum();

       System.out.println("Part 1:" + sum);
    }

    private static void part2(final List<String> answers) {

        final int sum = getAnsweredByAll(answers).stream().mapToInt(Set::size).sum();

        System.out.println("Part 2:" + sum);
    }

    private static List<Set<Character>> getAnsweredByAll(final List<String> answers) {
        final List<Set<Character>> answerSets = new ArrayList<>();

        for (String i: answers) {
            final Set<Character> allCharcters = i.replaceAll("\n", "").chars().mapToObj(e->(char)e).collect(Collectors.toSet());
            final List<Set<Character>> list = lineToSet(Arrays.asList(i.split("\n")));

            list.forEach(allCharcters::retainAll);

            answerSets.add(allCharcters);
        }
        return answerSets;
    }

    private static List<Set<Character>> lineToSet(final List<String> answers) {
        final List<Set<Character>> listOfAnswerSets = new ArrayList<>();

        for (String i:answers) {
            final Set<Character> charsSet = i.chars().mapToObj(e->(char)e).collect(Collectors.toSet());

            listOfAnswerSets.add(charsSet);
        }
        return listOfAnswerSets;
    }
}
