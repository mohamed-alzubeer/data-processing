package com.pluralsight.loops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("John", "Smith", 25),
                new Person("Sarah", "Johnson", 32),
                new Person("Michael", "Williams", 18),
                new Person("Emily", "Brown", 45),
                new Person("David", "Jones", 29),
                new Person("Jessica", "Garcia", 21),
                new Person("James", "Miller", 55),
                new Person("Ashley", "Davis", 37),
                new Person("Robert", "Wilson", 16),
                new Person("Amanda", "Taylor", 42)
        ));

        //ask the user for a name

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first or last name: ");

        String searchName = scanner.nextLine();

// Search using Stream and Lambda

        List<Person> searchPeople = people.stream()
                .filter(person ->
                        person.getFirstName().equalsIgnoreCase(searchName)
                                || person.getLastName().equalsIgnoreCase(searchName))
                .toList();

        System.out.println("\nMatching people: ");
        for(int i = 0; i < searchPeople.size(); i++) {
            Person person = searchPeople.get(i);
            System.out.println(person.getFirstName() + " " + person.getLastName());
        }

        //calculate the average age by using stream()
        double averageAge = people.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);
        System.out.println("Average age: " + averageAge);

        //display the age of oldest person by using stream()
        int oldAge = people.stream()
                .mapToInt(Person::getAge)
                .max()
                .orElse(0);
        System.out.println("Old age: " + oldAge);


        //display the age of the youngest person in the list
        int youngestAge = people.stream()
                .mapToInt(Person::getAge)
                .min()
                .orElse(0);
        System.out.println("Youngest age: " + youngestAge);

    }
}
