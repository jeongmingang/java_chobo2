package java_chobo2.ch14.stream;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamForEachToArrayEx {

	public static void main(String[] args) {
		IntStream.range(1, 10).sequential().forEach(new IntConsumer() {
			@Override
			public void accept(int value) {
				System.out.print(value);
			}
		});
		System.out.println();
		
		// 스트림의 모든 요소에 지정된 작업을 수행 –  forEach( ), forEachOrdered( )
		IntStream.range(1, 10).parallel().forEach(System.out::print);	// 병렬 스트림인경우 순서가 보장안됨
//		IntStream.range(1, 10).parallel().forEach(e -> System.out.print(e));	// 람다식 응용
		System.out.println();
		
		IntStream.range(1, 10).parallel().forEachOrdered(System.out::print); // 병렬스트림이어도 순서가 보장됨
		System.out.println();
		
		// 스트림을 배열로 변환 –  toArray( )
		Student[] stdArr = {new Student("김인환", 1, 200),
				new Student("이태훈", 1, 270),
				new Student("김상건", 2, 200),
				new Student("전수린", 2, 250),
		};
		Stream<Student> studentStream = Arrays.stream(stdArr);
		
		Student[] tempArr = studentStream.toArray(Student[]::new);
		System.out.println(Arrays.toString(tempArr));
		
		studentStream = Arrays.stream(stdArr);	// 스트림을 소모했으므로 다시 생성
		Object[] objArr = studentStream.toArray();
		System.out.println(Arrays.toString(objArr));
	}

}
