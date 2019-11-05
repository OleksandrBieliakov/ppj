package daftacademy;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final String SHIP_ID_REGEX = "(?<shipId>\\d+)";
    private static final String SHIP_NAME_REGEX = "(?<shipName>\\w+-?\\w*)";
    private static final String SHIP_CATEGORY_REGEX = "(?<shipCategory>\\w+-?\\w*)";
    //private static final String SHIP_REGEX = SHIP_ID_REGEX + ": " + SHIP_NAME_REGEX + " \\(" + SHIP_CATEGORY_REGEX + "\\)";
    private static final String SHIP_REGEX = "(?<shipId>\\d+): (?<shipName>\\w+-?\\w*) \\((?<shipCategory>\\w+-?\\w*)\\)";

    private static final Pattern SHIP_PATTERN = Pattern.compile(SHIP_REGEX);

    private static final String FROM_REGEX = "(?<from>\\p{Lu}\\p{Lu})";
    private static final String TO_REGEX = "(?<to>\\p{Lu}\\p{Lu})";
    private static final String CONTAINER_ID_REGEX = "(?<containerID>\\d+)";
    private static final String WEIGHT_REGEX = "(?<weight>\\d\\d\\d\\d)";
    private static final String CARGO_REGEX = "(?<cargo>[A-Z][0-9])";
    private static final String FIRM_NAME_REGEX = "(?<firmName>\\w+)";
    private static final String FIRM_COUNTRY_REGEX = "(?<firmCountry>\\p{Ll}\\p{Ll})";
    private static final String PRICE_REGEX = "(?<price>\\d+)";
    private static final String CONTAINER_REGEX = FROM_REGEX + "-" + TO_REGEX + "-" + CONTAINER_ID_REGEX + "/" +
            WEIGHT_REGEX + "/" + CARGO_REGEX + "@" + FIRM_NAME_REGEX + "\\." + FIRM_COUNTRY_REGEX + "/" + PRICE_REGEX;

    private static final Pattern CONTAINER_PATTERN = Pattern.compile(CONTAINER_REGEX);

    private static double parsePrice(String line) {
        int len = line.length();
        String dollars = line.substring(0, len - 2);
        String cents = line.substring(len - 2);
        return Double.parseDouble(dollars) + Double.parseDouble(cents) / 100;
    }

    public static Container parseContainer(String line) {
        Matcher matcher = CONTAINER_PATTERN.matcher(line);
        return new Container(
                matcher.group("from"),
                matcher.group("to"),
                matcher.group("containerID"),
                Integer.parseInt(matcher.group("weight")),
                matcher.group("cargo"),
                matcher.group("firmName") + matcher.group("firmCountry"),
                matcher.group("firmName"),
                matcher.group("firmCountry"),
                parsePrice(matcher.group("price"))
        );
    }

    private static void parseContainers(List<Ship> ships, String[] lines) {
        Iterator<Ship> iterator = ships.iterator();
        for (String line : lines)
            iterator.next().addContainer(parseContainer(line));
    }

    public static Ship parseShip(String line) {
        Matcher matcher = SHIP_PATTERN.matcher(line);
        return new Ship(Integer.parseInt(matcher.group("shipId")),
                matcher.group("shipName"), matcher.group("shipCategory"));
    }

    private static List<Ship> parseShips(String[] lines) {
        List<Ship> ships = new LinkedList<>();
        for (String line : lines)
            ships.add(parseShip(line));
        return ships;
    }

    private static String[] split(String line) {
        return line.split(";");
    }

    public static List<Ship> parseCSV(File file) {
        List<Ship> ships = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            if (line == null) return null;
            ships = parseShips(split(line));
            while ((line = br.readLine()) != null) {
                parseContainers(ships, split(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ships;
    }

}
