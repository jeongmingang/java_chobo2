package java_chobo2.ch14;

@FunctionalInterface
interface MyFuntion{
	void myMethod();
}

public class LambdaEx03 {

	public static void main(String[] args) {
		MyFuntion f = ()->System.out.println("myMethod()");
		aMethod(f);
		
		aMethod(()->System.out.println("myTwomethod()"));
	}

	public static void aMethod(MyFuntion f) {
		f.myMethod();
	}
}
