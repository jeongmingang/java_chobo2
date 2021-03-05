package java_chobo2.ch14.stream;

import java.util.Optional;
import java.util.OptionalInt;

public class OptionalEx {

	public static void main(String[] args) {
		Optional<String> optStr = Optional.of("abcde");
		Optional<Integer> optInt = optStr.map(String::length);
		System.out.println("optStr = " + optStr.get());	// abcde
		System.out.println("optInt = " + optInt.get());	// 길이 : 5
		
		int result1 = Optional.of("123")
						.filter(x->x.length() >0)
						.map(Integer::parseInt).get();	// .get():저장된 값을 반환(123)
		
		int result2 = Optional.of("")
				.filter(x->x.length() >0)
				.map(Integer::parseInt).orElse(-1);		// .orElse(""):저장된 값이 null일 경우 ""을 반환(-1)
		
		System.out.println("result1 = " + result1);
		System.out.println("result2 = " + result2);
		
		Optional.of("456").map(Integer::parseInt) 		
						.ifPresent(x->System.out.printf("result3 = %d%n", x));
		
		OptionalInt optInt1 = OptionalInt.of(0);	// 0을 저장
		OptionalInt optInt2 = OptionalInt.empty();	// 빈 객체를 생성(null)
		
		System.out.println(optInt1.isPresent());	// optInt1객체의 값이 null아니라서 "true"
		System.out.println(optInt2.isPresent());	// optInt2객체의 값이 null이여서 "false"
		
		System.out.println(optInt1.getAsInt());		// 0
//		System.out.println(optInt2.getAsInt());		// NoSuchElementException 발생

		System.out.println("optInt1 = " + optInt1);	//0
		System.out.println("optInt2 = " + optInt2);	//빈 객체
		System.out.println("optInt1.equals(optInt2)?" + optInt1.equals(optInt2));
	}
}
