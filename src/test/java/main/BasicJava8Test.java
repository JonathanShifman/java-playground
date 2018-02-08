package main;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
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
		strList = Arrays.asList("a", "aa", "aaa", "b", "bb", "bbb", "c", "cc", "ccc");
	}

	@Test
	public void test() {
		outputCollection = strList.stream()
		.filter((str) -> str.length() > 2)
		.collect(Collectors.toList());
		System.out.println(outputCollection);
	}

}
