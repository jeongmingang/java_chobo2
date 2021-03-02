package java_chobo2.ch14;

public class TriFunctionEx {

	public static void main(String[] args) {
		TriFunction<Integer, Integer, Integer, Integer> tri = new TriFunction<Integer, Integer, Integer, Integer>() {
			@Override
			public Integer appliy(Integer t, Integer u, Integer v) {
				return t * u * v;
			}
		};

		System.out.println(tri.appliy(10, 10, 10));
		
		TriFunction<Integer, Integer, Integer, Integer> tri01 = 
				(t, u, v) -> t * u * v;
		System.out.println(tri01.appliy(2, 2, 2));
	}

}
