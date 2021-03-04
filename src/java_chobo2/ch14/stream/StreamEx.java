package java_chobo2.ch14.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx {

	public static void main(String[] args) {
		String[] strArr = {"aaa", "ddd", "ccc"};
		List<String> strList = Arrays.asList(strArr);
		
		System.out.println(Arrays.toString(strArr));
		System.out.println(strList);
		
		// 1. 정렬
		// 2. 출력
		Arrays.sort(strArr);
		System.out.println(Arrays.toString(strArr));
		
		Collections.sort(strList);
		System.out.println(strList);
		
		// stream으로
		String[] strArr2 = {"aaa", "ddd", "ccc"};
		List<String> strList2 = Arrays.asList(strArr);
		
		Stream<String> strStream1 = Arrays.stream(strArr2);
		Stream<String> strStream2 = strList2.stream();
		
		strStream1.sorted().forEach(System.out::println);
		strStream2.sorted().forEach(System.out::println);
		
		// 스트림 특징
		//1. 스트림은 데이터 소스로부터 데이터를 읽기만할 뿐 변경하지 않는다.
		List<String> list = strList2.stream().sorted().collect(Collectors.toList());
		System.out.println(list);
		
		//2. 스트림은 Iterator처럼 일회용이다.(필요하면 다시 스트림을 생성해야 함)
		//위 코드에서 strStream1.sorted().forEach(System.out::println);
		//으로 사용했으므로 불가능(스트림이 닫힘)
		long cnt = Arrays.stream(strArr2).count();
		System.out.println(cnt);
		
		// 지연된 연산(최종 연산 전까지 중간연산이 수행되지 않는다.)
		IntStream intStream = new Random().ints(1, 46); // 1~45범위의 무한 스트림
		
		intStream.distinct().limit(6).sorted()			// 중간연산
				 .forEach(i->System.out.print(i+", ")); // 최종연산
		System.out.println();
		
		intStream = new Random().ints(1, 46); 
		intStream
		.distinct()
		.limit(6)
		.sorted()
		.forEach(i->System.out.print(i+", "));
		System.out.println();
		
		// 병렬 스트림 (스트림의 작업을 병렬로 처리)
 		Stream<String> strStream = Stream.of("dd", "aaa", "CC", "cc", "b");
 		int sum = strStream.parallel()		// strStream을 병렬 스트림으로 전환
 				.mapToInt(s -> s.length())	// // 모든 문자열의 길이의 합
 				.sum();
 		System.out.println("sum : " + sum);
	}

}
