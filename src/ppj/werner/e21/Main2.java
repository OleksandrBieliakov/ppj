package ppj.werner.e21;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int[] lim = {2, 3, 5, 7};

        System.out.println(
            Files.lines(Paths.get("data/task21.txt"))
                .flatMap(l -> Arrays.stream(l.split("\\W+")))
                .map(String::length)
                .map(c -> {
                    for (int i = 0; i < lim.length; i++)
                        if (c <= lim[i])
                            return i;
                    return lim.length;
                })
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .values()
        );
    }
}
