package ppj.pointedtasks.ppja26.t4and5;

import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "out/fruits-serialized.txt";

        FruitsList list = new FruitsList();
        list.push("Watermellon", 153869);
        list.push("Apple", 6);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(list);
        }

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(fileName));
        System.out.println(oin.readObject());
    }
}
