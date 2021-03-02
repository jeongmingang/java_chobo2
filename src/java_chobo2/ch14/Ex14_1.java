package java_chobo2.ch14;

@FunctionalInterface
interface MyFuntion2{
	void run();	// public abstract void run(); 추상형 메소드
}

public class Ex14_1 {

	static void execute(MyFuntion2 f) {
		f.run();
	}
	
	static MyFuntion2 getMyFuntion() {
		MyFuntion2 f = ()-> System.out.println("f3.run()");
		return f;
	}
	public static void main(String[] args) {
		
		MyFuntion2 f1 = ()-> System.out.println("f1.run()");
		
		MyFuntion2 f2 = new MyFuntion2() {
			@Override
			public void run() {
				System.out.println("f2.run()");
			}
		}; 
		
		MyFuntion2 f3 = getMyFuntion();
		
		f1.run();
		f2.run();
		f3.run();
		
		execute(f1);
		execute( ()-> System.out.println("run()") );
	}

}
