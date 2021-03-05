package java_chobo2.ch14.stream;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMapEx {

	public static void main(String[] args) {
//		extracted();
//		extracted2();
		
		IntStream intStream = new Random().ints(1,46);   	// 1~45사이의 정수(46은 포함안됨)
		Stream<Integer> integerStream = intStream.boxed();	// IntStream → Stream<Integer>
		integerStream.limit(6).forEach(System.out::println);
		
		Stream<String> lottoStream = new Random().ints(1,46)
				.distinct().limit(6).sorted()
				.mapToObj(i -> i+",");			// IntStream -> Stream<String>
		lottoStream.forEach(System.out::print);	// 12,14,20,23,26,29,
		
	}// end of main

	public static void extracted2() {
		List<Student> list = new ArrayList<>();
		list.add(new Student("이자바", 3, 300));
		list.add(new Student("김자바", 1, 200));
		list.add(new Student("안자바", 2, 100));
		list.add(new Student("박자바", 2, 150));
		list.add(new Student("소자바", 1, 200));
		list.add(new Student("나자바", 3, 290));
		list.add(new Student("감자바", 3, 180));

		Stream<Student> stdStream = list.stream();
			
		// 스트림을 기본 스트림으로 변환
		Stream<Integer> stdScoreStream = stdStream.map(Student::getTotalscore);
//		stdScoreStream.forEach(System.out::println);	//점수만 출력
		int total = stdScoreStream.reduce(0, (a, b) -> a+b); //총합계점수 출력(1420)
		System.out.println(total);
		
		stdStream = list.stream();
		IntStream stdScoreIntStream = stdStream.mapToInt(Student::getTotalscore);
		total = stdScoreIntStream.max().getAsInt();			//최고 점수 출력(300)
//		total = stdScoreIntStream.sum();			//총합계점수 출력(1420)
		System.out.println(total);
	}

	public static void extracted() {
		List<File> list = new ArrayList<File>();
		list.add(new File("Ex1.java"));
		list.add(new File("Ex1.bak"));
		list.add(new File("Ex2.java"));
		list.add(new File("Ex1"));
		list.add(new File("Ex1.txt"));
		
		// map()으로 Stream<File>을 Stream<String>으로 변환
		Stream<File> fileStream = list.stream();
		Stream<String> filenameStream = fileStream.map(File::getName);
		filenameStream.forEach(System.out::println); // 모든 파일의 이름을 출력
		System.out.println();
		
		list.stream().map(File::getName)		 // Stream<File> -> Stream<String>
		.filter(s -> s.indexOf('.') != -1)		 // 확장자가 없는 것은 제외
		.peek(System.out::println)				 //peek()-> 중간결과를 올바르게 처리 되었는지 확인(스트림소모X)
		.map(s -> s.substring(s.indexOf('.')+1)) // 확장자만 추출
		.peek(s->System.out.printf("extends %s%n", s)) 
		.map(String::toUpperCase)				 // 모두 대문자로 변환
		.peek(s->System.out.printf("upper %s%n", s))
		.distinct()								 // 중복 제거
		.forEach(System.out::print);			 // JAVABAKTXT			
		
		System.out.println();
		
		
		
		//
	/*	Set<String> s = new HashSet<>();
		for(File f : list) {
			String ext = f.getName();
			if (ext.indexOf('.') != -1) {
				s.add(ext.substring(ext.indexOf('.')+1).toUpperCase());
			}
		}
		System.out.println(s);
		
		File file = new File("test.java");
		String fileName = file.getName();	// "test.java"가 추출
		int idx = fileName.indexOf("."); 	// 4
		System.out.println(fileName + " : " + idx);
		System.out.println(fileName.substring(idx+1));	// idx이후로 끝까지 출력 : "java"출력
	*/
	}

}
