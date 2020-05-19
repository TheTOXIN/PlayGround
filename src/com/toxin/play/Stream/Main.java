package com.toxin.play.Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Юра", 19),
                new Person("Паша", 21),
                new Person("Влад", 25),
                new Person("Костя", 20),
                new Person("Сепега", 18),
                new Person("Игорь", 23)
        );

        double average = people.stream()
                .filter(p -> p.getAge() > 20)
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();

        people.stream()
                .filter((Person p) -> (p.getAge() > 20))
                .sorted(Comparator.comparing(Person::getName))
                .map(Person::getName)
                .forEach(System.out::println);

        System.out.println("Средний возраст - " + average);
    }
}
