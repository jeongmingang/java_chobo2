package java_chobo2.ch14;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaEx02 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("abc", "aaa", "bbb", "ddd", "aaa");
		//정렬(abc순으로:사전순)
		System.out.println(list);
		
		Comparator<String> comp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		};
		Collections.sort(list, comp);	// 역순으로 정렬됨
		System.out.println(list);
		
		Collections.sort(list, (o1, o2)->o1.compareTo(o2)); // 사전순으로 정렬됨
		System.out.println(list); 
	}

}
