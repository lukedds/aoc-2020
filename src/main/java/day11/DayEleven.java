package day11;

import helpers.Helpers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class DayEleven {

    static int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args) throws FileNotFoundException {
        
        long startTimePart1 = System.currentTimeMillis();
        part1(Helpers.getInputAsCharArrayLists("day11"));
        long endTimePart1 = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTimePart1 - startTimePart1) + "ms");

        long startTimePart2 = System.currentTimeMillis();
        part2(Helpers.getInputAsCharArrayLists("day11"));
        long endTimePart2 = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTimePart2 - startTimePart2) + "ms");

    }

    public static void part1(final ArrayList<ArrayList<Character>> input) {
        ArrayList<ArrayList<Character>> newGrid = input;
        ArrayList<ArrayList<Character>> oldGrid = new ArrayList<>();

        while (!newGrid.equals(oldGrid)) {
            ArrayList<ArrayList<Character>> tempGrid = newGrid;
            oldGrid = new ArrayList<>();
            for(ArrayList<Character> p : newGrid) {
                oldGrid.add((ArrayList<Character>) p.clone());
            }
            newGrid = actionGrid(tempGrid);
        }
        int count = 0;
        for (ArrayList<Character> c: newGrid) {
            count += Collections.frequency(c, '#');
        }

        System.out.println("Occupied: " + count);
    }

    public static void part2(final ArrayList<ArrayList<Character>> input) {
        ArrayList<ArrayList<Character>> newGrid = input;
        ArrayList<ArrayList<Character>> oldGrid = new ArrayList<>();

        while (!newGrid.equals(oldGrid)) {
            ArrayList<ArrayList<Character>> tempGrid = newGrid;
            oldGrid = new ArrayList<>();
            for(ArrayList<Character> p : newGrid) {
                oldGrid.add((ArrayList<Character>) p.clone());
            }
            newGrid = actionGridPart2(tempGrid);
        }
        int count = 0;
        for (ArrayList<Character> c: newGrid) {
            count += Collections.frequency(c, '#');
        }

        System.out.println("Occupied: " + count);
    }

    private static final ArrayList<ArrayList<Character>> actionGridPart2(final ArrayList<ArrayList<Character>> input) {
        ArrayList<ArrayList<Character>> newGrid = new ArrayList<>();

        for(ArrayList<Character> p : input) {
            newGrid.add((ArrayList<Character>) p.clone());
        }

        for (int row = 0; row < input.size(); row++)
        {
            for (int col = 0; col < input.get(row).size(); col++)
            {
                Character current = input.get(row).get(col);
                if (countNeighboursPart2(input, row, col) >= 5 && current == '#') {
                    newGrid.get(row).set(col, 'L');
                }
                if (countNeighboursPart2(input, row, col) == 0 && current == 'L') {
                    newGrid.get(row).set(col, '#');
                }
            }

        }
        return newGrid;
    }

    private static final ArrayList<ArrayList<Character>> actionGrid(final ArrayList<ArrayList<Character>> input) {
        ArrayList<ArrayList<Character>> newGrid = new ArrayList<>();

        for(ArrayList<Character> p : input) {
            newGrid.add((ArrayList<Character>) p.clone());
        }

        for (int row = 0; row < input.size(); row++)
        {
            for (int col = 0; col < input.get(row).size(); col++)
            {
                Character current = input.get(row).get(col);
                if (!current.equals('.')) {
                    if (countNeighbours(input, row, col) >= 4 && current == '#') {
                        newGrid.get(row).set(col, 'L');
                    }
                    if (countNeighbours(input, row, col) == 0 && current == 'L') {
                        newGrid.get(row).set(col, '#');
                    }
                }
            }

        }
        return newGrid;
    }

    private static int countNeighbours(final ArrayList<ArrayList<Character>> input, final int row, final int col) {

        int count = 0;

        for (int[] i: directions) {
            try {
                if (input.get(row + i[0]).get(col + i[1]) == '#') {
                    count ++;
                }
            } catch (IndexOutOfBoundsException e) {
                // do nothing
            }
        }
        return count;
    }

    private static int countNeighboursPart2(final ArrayList<ArrayList<Character>> input, final int row, final int col) {

        int count = 0;

        outer:
        for (int[] i: directions) {
            int rowIndex = i[0];
            int colIndex = i[1];
            boolean hitOOB = false;
            while (!hitOOB) {
                try {
                    if (input.get(row + rowIndex).get(col + colIndex) == 'L') {
                        continue outer;
                    }
                    if (input.get(row + rowIndex).get(col + colIndex) == '#') {
                        count++;
                        continue outer;
                    }
                    rowIndex += i[0];
                    colIndex += i[1];
                } catch (IndexOutOfBoundsException e) {
                    hitOOB = true;
                }

            }
        }
        return count;
    }
}
