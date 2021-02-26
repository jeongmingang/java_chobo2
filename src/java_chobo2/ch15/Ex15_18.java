package java_chobo2.ch15;

import java.io.File;

public class Ex15_18 {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Usage : java Ex_18 DIRETORY");
			System.exit(0);
		}

		File dir = new File(args[0]);
		
		if(!dir.exists() || !dir.isDirectory()) {
			System.out.println("유효하지 않는 디렉토리입니다.");
			System.exit(0);
		}
		
		File[] list = dir.listFiles();
		
		for(int i = 0; i < list.length; i++) {
			String filename = list[i].getName();
			//파일명
			
		}
	}

}
