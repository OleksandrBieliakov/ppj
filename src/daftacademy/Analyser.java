package daftacademy;

import java.util.*;

public class Analyser {

    public static int numberOfContainersDeliveredToCountry(List<Ship> ships, String country) {
        int count = 0;
        for (Ship ship : ships)
            for (Container container : ship.getContainers())
                if (container.getToCountry().equals(country))
                    count++;
        return count;
    }


    public static String shipCategoryCarryingMostContainers(List<Ship> ships) {
        Map<String, List<Integer>> numbersOfContainersForCategory = new HashMap<>();
        for (Ship ship : ships) {
            String category = ship.getCategory();
            List<Integer> bucket = numbersOfContainersForCategory.computeIfAbsent(category, key -> new LinkedList<>());
            bucket.add(ship.numberOfContainers());
        }

        Iterator<String> iterator = numbersOfContainersForCategory.keySet().iterator();
        String maxShipType = iterator.next();
        double maxAverage = numbersOfContainersForCategory.get(maxShipType).stream().mapToInt(Integer::intValue).average().orElse(Double.NaN);

        while (iterator.hasNext()) {
            String shipType = iterator.next();
            double average = numbersOfContainersForCategory.get(shipType).stream().mapToInt(Integer::intValue).average().orElse(Double.NaN);
            if (average > maxAverage) {
                maxShipType = shipType;
                maxAverage = average;
            }
        }
        return maxShipType;
    }

    public static int averageContainerWeightWith(List<Ship> ships, String material) {
        return 0;
    }

    public static String firmFromCountrySentMostContainers(List<Ship> ships, String country) {
        return "";
    }

    public static String mostExpensiveCargoTypeExportedFromCountryByItsFirms(List<Ship> ships, String country) {
        return "";
    }

    public static int totalNumberOfContainers(List<Ship> ships) {
        int count = 0;
        for (Ship ship : ships)
            count += ship.numberOfContainers();
        return count;
    }

}
