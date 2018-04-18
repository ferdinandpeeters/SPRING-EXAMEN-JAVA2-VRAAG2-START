package edu.ap.spring;

import java.awt.Point;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class Exam {
	
	// Maak gebruik van lambdas en streams om een array met alle
	// priemgetallen terug te geven
	// 2 punten
	public int[] getPrimes(int[] numbers) {
		return Arrays.stream(numbers)
				.filter(x -> IntStream.rangeClosed(2, (int) Math.sqrt(x)).noneMatch(i -> x%i == 0))
				.toArray();
	}
	
	// Maak gebruik van lambdas en streams alle lowercase characters
	// te tellen in de gegeven string
	// 1 punt
	public int countLowercaseCharacters(String string) {
		return (int) string.chars()
			.mapToObj(i -> (char)i)
			.filter(x -> Character.isLowerCase(x))
			.count();
	}
	
	// Maak gebruik van lambdas en streams om de som van alle
	// x-coordinaten uit de lijst van points te berekenen
	// 1 punt
	public int sumOfX(List<Point> points) {
		return points.stream()
				.map(x -> x.getX())
				.mapToInt(i -> i.intValue())
				.sum();
	}
	
	// Maak gebruik van lambdas en streams om een comma-separated
	// string te maken die alle x-coordinaten bevat die groter of gelijk 
	// zijn aan twee
	// 2 punten
	public String getXOverTwo(List<Point> points) {
		return  points.stream()
				.map(x -> x.getX())
				.mapToInt(Double::intValue)
				.filter(x -> x >= 2)
		        .mapToObj(String::valueOf)
		        .collect(Collectors.joining(", "));
	}
}
