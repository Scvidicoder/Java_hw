package semestr4.lab2;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Human {
    private int age;
    private String firstName;
    private String lastName;
    private LocalDate date;
    private int weight;

    public Human(String firstName, String lastName, int age, int weight, LocalDate date) {
        this.age = age;
        this.date = date;
        this.firstName = firstName;
        this.lastName = lastName;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "\nHuman{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", date=" + date +
                ", weight=" + weight +
                '}';
    }

    public static void main(String[] args) {
        List<Human> humans = List.of(
                new Human("John", "Doe", 25, 70, LocalDate.of(1997, 5, 10)),
                new Human("Alice", "Smith", 10, 65, LocalDate.of(1992, 8, 20)),
                new Human("Bob", "Johnson", 22, 75, LocalDate.of(2000, 2, 15)),
                new Human("Bopb", "Johnson", 22, 75, LocalDate.of(2000, 2, 15))

        );

        List<Human> sortedByLastNameDesc = humans.stream()
                .sorted(Comparator.comparing(Human::getFirstName).reversed())
                .collect(Collectors.toList());

        List<Human> filteredByAge = humans.stream()
                .filter(human -> human.getAge() > 20)
                .collect(Collectors.toList());

        List<Human> firstThree = humans.stream()
                .limit(3)
                .collect(Collectors.toList());

        String concatenatedNames = firstThree.stream()
                .map(Human::getFirstName)
                .collect(Collectors.joining(" "));

        System.out.println("Сортировка по имени в обратном порядке: " + sortedByLastNameDesc);
        System.out.println("Фильтрация по возрасту больше 20: " + filteredByAge);
        System.out.println("Выбор первых 3 элементов списка: " + firstThree);
        System.out.println("Конкатенация имен в строку через пробел: " + concatenatedNames);
    }
}
