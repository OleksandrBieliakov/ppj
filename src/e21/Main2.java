package e21;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int[] lim = {2, 3, 5, 7};

        System.out.println(
            Files.lines(Paths.get("data/task21.txt"))
                .flatMap(l -> stream(l.split("\\W+")))
                .map(String::length)
                .map(c -> {
                    for (int i = 0; i < lim.length; i++)
                        if (c <= lim[i])
                            return i;
                    return lim.length;
                })
                .collect(groupingBy(c -> c, counting()))
                .values()
        );
    }
}
