package com.saurabh.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class MapDemo {
	
	public static List<Person> createPeople() {
		return Arrays.asList(
			new Person("Sara",Gender.FEMALE, 20),
			new Person("Sara",Gender.FEMALE, 22),
			new Person("Bob",Gender.MALE, 20),
			new Person("Paula",Gender.FEMALE, 32),
			new Person("Paul",Gender.MALE, 32),
			new Person("Jack",Gender.MALE, 2),
			new Person("Jack",Gender.MALE, 72),
			new Person("Jill",Gender.FEMALE, 12)
		);
	}
	
	public static void main(String[] args) {
		List<Person> people = createPeople();
		
		// Create a Map with name and age as key, and the person as value.
		Map<String, Person> personMap = people.stream()
			  .collect(toMap(person -> person.getName()+"-"+person.getAge(),person -> person));
		System.out.println(personMap);
	}
}
