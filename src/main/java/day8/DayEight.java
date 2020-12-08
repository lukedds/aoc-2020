package day8;

import helpers.Helpers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DayEight {

    public static void main(String[] args) throws FileNotFoundException {

        LinkedList<String> input = Helpers.getInputAsLinkedStrings("day8");

        part1(input);
        part2(input);
    }

    public static void part1(final List<String> input) {

        System.out.println("ACC UPON COMPLETION:" + executeInstructionsUntilTermination(input));
    }

    public static Integer part2(final LinkedList<String> input) {

        for (int i = 0; i < input.size(); i++) {
            if (getOperation(input.get(i)).equals("nop")) {
                LinkedList<String> newInput = (LinkedList<String>) input.clone();
                newInput.set(i, newInput.get(i).replaceAll("nop", "jmp"));
                executeInstructionsUntilTermination(newInput);
            }
            else if (getOperation(input.get(i)).equals("jmp")) {
                LinkedList<String> newInput = (LinkedList<String>) input.clone();
                newInput.set(i, newInput.get(i).replaceAll("jmp", "nop"));
                executeInstructionsUntilTermination(newInput);
            }
        }
        return 0;
    }

    private static Integer executeInstructionsUntilTermination(List<String> input) {
        List<Integer> visited = new ArrayList<>();
        int currentIndex = 0;
        int acc = 0;

        try {
            while (!visited.contains(currentIndex)) {
                String instruction = input.get(currentIndex);

                if (getOperation(instruction).equals("acc")) {
                    visited.add(currentIndex);
                    acc += getArgument(instruction);
                    currentIndex += 1;
                }
                if (getOperation(instruction).equals("jmp")) {
                    visited.add(currentIndex);
                    currentIndex += getArgument(instruction);
                }
                if (getOperation(instruction).equals("nop")) {
                    visited.add(currentIndex);
                    currentIndex += 1;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ACC TERMINATED WITH VALUE:" + acc);
            return acc;
        }

        return acc;
    }

    public static String getOperation(final String instruction) {
        return instruction.split(" ")[0];
    }

    public static Integer getArgument(final String instruction) {
        return Integer.parseInt(instruction.split(" ")[1]);
    }

}
