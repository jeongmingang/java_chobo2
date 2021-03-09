package java_chobo2.ch14.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class StreamFinalEx2 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("이자바", 3, 300));
		list.add(new Student("김자바", 1, 200));
		list.add(new Student("안자바", 2, 100));
		list.add(new Student("박자바", 2, 150));
		list.add(new Student("소자바", 1, 95));
		list.add(new Student("나자바", 3, 290));
		list.add(new Student("감자바", 3, 80));

		//스트림을 컬렉션을 변환
//		extracted(list);
		
		//스트림의 통계정보
		extracted2(list);
	}

	public static void extracted2(List<Student> list) {
		//스트림의 통계정보
		long cnt1 = list.stream().count();
		long cnt2 = list.stream().collect(Collectors.counting());
		System.out.printf("count %d, %d%n", cnt1, cnt2);
		
		int sum1 = list
				.parallelStream()
				.mapToInt(Student::getTotalscore)
				.peek(System.out::println)
				.sum();
		
		int sum2 = list
				.parallelStream()
				.collect(Collectors.summingInt(Student::getTotalscore));
		
		System.out.printf("totalscore %d, %d%n", sum1, sum2);
		
		OptionalInt max1 = list
		.parallelStream()
		.mapToInt(Student::getTotalscore)
		.peek(System.out::println)
		.max();
		System.out.printf("maxScore %d%n", max1.getAsInt());
		
		Optional<Student> maxStd1 =
				list
				.parallelStream()
				.max(Comparator.comparingInt(Student::getTotalscore));
		Student std = maxStd1.get();
		System.out.println(std);
		
		Optional<Student> maxStd2 =
				list
				.parallelStream()
				.collect(Collectors.maxBy(
						Comparator.comparingInt(Student::getTotalscore)));
		Student std1 = maxStd2.get();
		System.out.println(std1);
		
		IntSummaryStatistics iss1 = list
									.parallelStream()
									.mapToInt(Student::getTotalscore)
									.summaryStatistics();
		System.out.println(iss1);
		
		IntSummaryStatistics iss2 = list
									.parallelStream()
									.collect(Collectors.summarizingInt(Student::getTotalscore));
		System.out.println(iss2);
	}
	
	public static void extracted(List<Student> list) {
		//스트림을 컬렉션으로 변환
		List<String> stdList = list
				.stream()
				.map(Student::getName)
				.peek(System.out::println)
				.collect(Collectors.toList());
				
		System.out.println(stdList);
		
		Collection<Student> asList = list.stream()
				.collect(Collectors.toCollection(ArrayList::new));
		System.out.println(asList);
		
		//Map<이름, 학생>
		Map<String, Student> map = list.stream()
				.collect(Collectors.toMap(s->s.getName(), s->s));
		
		for(Entry<String, Student> e : map.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}

}
