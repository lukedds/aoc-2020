package helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

    public static ArrayList<String> getInputAsStrings(final String day) throws FileNotFoundException {

        final String path = String.format("src/main/resources/%s/input", day);
        final Scanner s = new Scanner(new File(path));
        final ArrayList<String> list = new ArrayList<String>();
        while (s.hasNextLine()){
            list.add(s.nextLine());
        }
        s.close();

        return list;
    }
}
