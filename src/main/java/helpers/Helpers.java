package helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Helpers {

    public static ArrayList<Integer> getInputAsIntegers(final String day) throws FileNotFoundException {

        final String path = String.format("src/main/resources/%s/input", day);
        final Scanner s = new Scanner(new File(path));
        final ArrayList<Integer> list = new ArrayList<Integer>();
        while (s.hasNextLine()){
            list.add(Integer.parseInt(s.nextLine()));
        }
        s.close();

        return list;
    }

    public static ArrayList<ArrayList<Character>> getInputAsCharArrayLists(final String day) throws FileNotFoundException {

        final String path = String.format("src/main/resources/%s/input", day);
        final Scanner s = new Scanner(new File(path));
        final ArrayList<ArrayList<Character>> list = new ArrayList<>();
        while (s.hasNextLine()){
            final ArrayList<Character> charList = new ArrayList<>();

            for (char c : s.nextLine().toCharArray()) {
                charList.add(c);
            }

            list.add(charList);
        }
        s.close();

        return list;
    }

    public static ArrayList<Long> getInputAsLongs(final String day) throws FileNotFoundException {

        final String path = String.format("src/main/resources/%s/input", day);
        final Scanner s = new Scanner(new File(path));
        final ArrayList<Long> list = new ArrayList<Long>();
        while (s.hasNextLine()){
            list.add(Long.parseLong(s.nextLine()));
        }
        s.close();

        return list;
    }

    public static ArrayList<String> getInputAsStrings(final String day) throws FileNotFoundException {

        final String path = String.format("src/main/resources/%s/input", day);
        final Scanner s = new Scanner(new File(path));
        final ArrayList<String> list = new ArrayList<>();
        while (s.hasNextLine()){
            list.add(s.nextLine());
        }
        s.close();

        return list;
    }

    public static LinkedList<String> getInputAsLinkedStrings(final String day) throws FileNotFoundException {

        final String path = String.format("src/main/resources/%s/input", day);
        final Scanner s = new Scanner(new File(path));
        final LinkedList<String> list = new LinkedList<String>();
        while (s.hasNextLine()){
            list.add(s.nextLine());
        }
        s.close();

        return list;
    }

    public static String getInputAsString(final String day) throws IOException {

        return Files.readString(Paths.get(String.format("src/main/resources/%s/input", day)));
    }
}
