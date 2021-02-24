package java_chobo2.ch13;

public class ThreadEx01 {

	public static void main(String[] args) throws InterruptedException {
		Thread01 th1 = new Thread01();
		th1.start(); // thread th1을 실행
//		th1.run(); // 함수로 호출(멀티쓰레드가 아님)
		
		Thread02 runnable = new Thread02();
		Thread th2 = new Thread(runnable);
		th2.start();
		
		for(int i = 0; i<10; i++) {
			System.out.println(i);
			Thread.sleep(1000);
		}
		
		System.out.println("Done.");
	}

}
