package com.saurabh.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.mapping;

public class GroupingByDemo {
	
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
		
		// Given a list of people, create a map where their name is the key and value is all the people with that NAME
		Map<String, List<Person>> personMap = people.stream()
			  .collect(groupingBy(Person::getName));
		System.out.println(personMap);
		
		// Given a list of people, create a map where their name is the key and value is all the AGES of people with that NAME
		Map<String, List<Integer>> personAgeMap = people.stream()
				  .collect(groupingBy(Person::getName, 
						  mapping(Person::getAge, toList())));
			System.out.println(personAgeMap);
	}
}
