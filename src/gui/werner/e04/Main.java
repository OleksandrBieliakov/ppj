package gui.werner.e04;

import ppj.werner.e11.p1.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        ArrayList<Person> list = new ArrayList<>();

        String name;
        String year;

        while (true) {
            name = scan.nextLine();
            try {
                year = scan.nextLine();
                list.add(new Person(name, Integer.parseInt(year)));
            } catch (Exception e) {
                System.out.println("Year of birth must be an integer.\n" +
                        "Please enter name and year again.");
                continue;
            }
        }


    }

}
