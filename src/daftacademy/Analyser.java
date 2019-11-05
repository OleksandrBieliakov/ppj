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

    public static int averageContainerWeightWith(List<Ship> ships, String cargo) {
        List<Integer> weights = new LinkedList<>();
        for (Ship ship : ships) {
            for (Container container : ship.getContainers()) {
                if (container.getCargoType().equals(cargo)) {
                    weights.add(container.getWeight());
                }
            }
        }
        return (int) weights.stream().mapToInt(Integer::intValue).average().orElse(Double.NaN);
    }

    public static String firmFromCountrySentMostContainers(List<Ship> ships, String country) {
        Map<String, Integer> firms = new HashMap<>();
        for (Ship ship : ships) {
            for (Container container : ship.getContainers()) {
                if (container.getFirmCounty().equals(country)) {
                    String firmName = container.getFirmName();
                    firms.computeIfPresent(firmName, (k, v) -> v + 1);
                    firms.putIfAbsent(firmName, 1);
                }
            }
        }

        Set<Map.Entry<String, Integer>> entries = firms.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();

        Map.Entry<String, Integer> entry = iterator.next();
        String maxFirm = entry.getKey();
        Integer maxContainers = entry.getValue();

        while (iterator.hasNext()) {
            entry = iterator.next();
            Integer containers = entry.getValue();
            if (containers.compareTo(maxContainers) > 0) {
                maxFirm = entry.getKey();
                maxContainers = containers;
            }
        }
        return maxFirm;
    }

    public static String mostExpensiveCargoTypeExportedFromCountry(List<Ship> ships, String country) {
        Map<String, Double> valuesOfCargoes = new HashMap<>();
        for (Ship ship : ships) {
            for (Container container : ship.getContainers()) {
                if (container.getFirmCounty().equals(country) && container.getFromCountry().equalsIgnoreCase(country)) {
                    String cargoType = container.getCargoType();
                    Double value = container.getPrice() / container.getWeight();
                    valuesOfCargoes.computeIfPresent(cargoType, (k, v) -> Math.max(v, value));
                    valuesOfCargoes.putIfAbsent(cargoType, value);
                }
            }
        }

        Set<Map.Entry<String, Double>> entries = valuesOfCargoes.entrySet();
        Iterator<Map.Entry<String, Double>> iterator = entries.iterator();

        Map.Entry<String, Double> entry = iterator.next();
        String maxCargo = entry.getKey();
        Double maxValue = entry.getValue();

        while (iterator.hasNext()) {
            entry = iterator.next();
            Double value = entry.getValue();
            if (value.compareTo(maxValue) > 0) {
                maxCargo = entry.getKey();
                maxValue = value;
            }
        }
        return maxCargo;
    }

    public static int totalNumberOfContainers(List<Ship> ships) {
        int count = 0;
        for (Ship ship : ships)
            count += ship.numberOfContainers();
        return count;
    }

}
