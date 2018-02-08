package main;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BasicJava8Test {
	
	private static List<String> strList;
	
	private Collection<String> outputCollection;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		strList = Arrays.asList("a", "b", "c", "aa", "bb", "cc", "aaa", "bbb", "ccc");
	}

	@Test
	public void testIntermediateOps() {
		outputCollection = strList.stream()
				.map(str -> str + str)
				.filter(str -> str.length() >= 3)
				.collect(Collectors.toList());
				System.out.println(outputCollection);

		Predicate<String> largerThan3Predicate = str -> str.length() >= 3;
		outputCollection = strList.stream()
				.map(this::duplicate)
				.filter(largerThan3Predicate)
				.sorted()
				.collect(Collectors.toList());
				System.out.println(outputCollection);
	}
	
	private String duplicate(String str) {
		return str + str;
	}
	
	@Test
	public void testTeminalOps() {
		
	}
	
	private String concatenateToBeginning(String str1, String str2) {
		return str2 + str1;
	}

}
