package com.saurabh.test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;
import java.util.stream.Collectors;

public class WordCounter {
	
	public static void main(String[] args) {
		String filePath = "/Users/ssur/Kaiser/testws/FileTest/src/com/saurabh/test/Paragraph_txt.txt";
		try {
			File file = new File(filePath);
			if (file.exists()) {
				System.out.println("File exist");
				Path path = file.toPath();
				if (path != null) {
					List<String> lines = Files.readAllLines(path);
					Map<String,Long> resultMap = lines.stream()
						.flatMap(line -> Arrays.stream(line.trim().split(" ")))
						.map(String::trim)
						.map(e -> e.replaceAll("^a-zA-Z", ""))
						.filter(e -> e.length() > 0)
						.map(e -> new SimpleEntry<>(e,1))
						.sorted()
						.collect(Collectors.groupingBy((SimpleEntry::getKey), Collectors.counting())
						);
					
					Map<String, Long> result = resultMap.entrySet().stream()
			                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
			                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
			                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
					
					
					// resultMap.forEach((word,count) -> System.out.println(String.format("Word :[ %s ] has count -> %d", word, count)));
					result.forEach((word,count) -> System.out.println(String.format("Word :[ %s ] has count -> %d", word, count)));
				}
			} else {
				System.out.println("File does not exist");
			}
		} catch (Exception ex) {
			System.out.println(
					"Exception occurred try to fetch file from path -> " + filePath + ". Reason: " + ex.getMessage());
		}
	}

}
