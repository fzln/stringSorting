package mypackage;

import java.util.*;

public class MyClass {
    public static void main(String[] args) {
        String s = "сапог сарай арбуз болт бокс биржа";

        // Intermediate splitted data
        String[] arrayStrins = s.split(" ");

        // Collector of Data
        Map<Character, Set<String>> mapOfStrings = new TreeMap<>();

        // Processing of packing to Output Structure
        for (String str : arrayStrins) {
            Character charFirst = str.charAt(0);

            mapOfStrings.computeIfAbsent(charFirst, k -> {
                        Set<String> setInChar = new TreeSet<>((o1, o2) -> {
                            if (o1.length() > o2.length()) return -1;
                            if (o1.length() < o2.length()) return 1;
                            return o1.compareTo(o2);
                        });
                        mapOfStrings.put(charFirst, setInChar);
                        return setInChar;
                    }
            ).add(str);
        }

        // Print Data
        mapOfStrings.forEach((key, value) -> {
            if (value.size() > 1) {
                System.out.print(key + "=[");
                value.forEach(str -> System.out.print(str + ", "));
                System.out.print("] ");
            }
        });
    }
}
