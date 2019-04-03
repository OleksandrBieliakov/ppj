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

        System.out.println("Enter \"end\" after Name: to finish input.");

        while (true) {
            System.out.print("Name: ");
            name = scan.nextLine();
            if (name.equals("end")) break;
            try {
                System.out.print("Year: ");
                year = scan.nextLine();
                list.add(new Person(name, Integer.parseInt(year)));
            } catch (Exception e) {
                System.out.println("Year of birth must be an integer.\n" +
                        "Please enter name and year again.");
                continue;
            }
            System.out.println();
        }

        System.out.println(list);

    }

}
