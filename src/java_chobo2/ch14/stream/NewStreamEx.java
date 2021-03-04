package java_chobo2.ch14.stream;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NewStreamEx {

	public static void main(String[] args) {
		IntStream.range(1, 10).forEach(System.out::print);	//끝인 10이 미포함
		System.out.println();
		IntStream.rangeClosed(1, 10).forEach(System.out::print); //끝인 10이 포함
		System.out.println();
		
		//난수를 요소로
		new Random(1234).ints().limit(5).sorted().forEach(System.out::println);
		System.out.println();
		System.out.printf("ints() range -> %d ~ %d%n", Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		new Random(1234).ints(5).sorted().forEach(System.out::println);
		System.out.println();
		
		
	}

}
