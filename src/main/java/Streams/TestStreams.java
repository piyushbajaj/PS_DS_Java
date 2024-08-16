package Streams;

import java.util.Arrays;
import java.util.List;

//@Getter
//@Setter
//class Company {
//	List<Person> persons;
//	Company(List<Person> persons) {
//		this.persons = persons;
//	}
//}
//
//@Getter
//@Setter
//class Person {
//	String name;
//	Person(String name) {
//		this.name = name;
//	}
//}


public class TestStreams {
//	public static void loopFun() {
//		List<Company> companies = Arrays.asList(
//			new Company(Arrays.asList(new Person("Jon Skeet"), new Person("Linus Torvalds"))),
//			new Company(Arrays.asList(new Person("Dennis Ritchie"), new Person("Bjarne Stroustrup"))),
//			new Company(Arrays.asList(new Person("James Gosling"), new Person("Patrick Naughton")))
//		);
//
//		List<String> persons = companies.stream()
//			.flatMap(company -> company.getPersons().stream())
//			.map(Person::getName)
//			.collect(Collectors.toList());
//
//		System.out.println("Persons: " + persons);
//	}


    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(2, 3, 4, 5);
        System.out.println("Printing number" + number);

//		List<String> square =
//			number.stream().map(String::valueOf).collect(Collectors.joining(",")).collect(Collectors.toList());
//
//		System.out.println("Printing Square" + square);


        List<String> strings = Arrays.asList("a", "b", "c", "d");
        strings.replaceAll(s -> "D" + s);
        System.out.println(strings);

//		Stream<Integer> stream = Stream.of(number)

        number.stream().forEach(p -> System.out.println(p));

//		loopFun();
    }
}
