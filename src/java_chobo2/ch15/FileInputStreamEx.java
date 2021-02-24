package java_chobo2.ch15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamEx {

	public static void main(String[] args) throws FileNotFoundException, IOException {
//		FileInputStreamEx(); 
		File file = new File("screen.png");
		try (FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis, 8192);
				
				FileOutputStream fos = new FileOutputStream("test2.png");
				BufferedOutputStream bos = new BufferedOutputStream(fos, 8192)) {
			int data = 0;
			while( (data = bis.read()) !=-1) {
				bos.write(data);
			}
		}
	}

	public static void FileInputStreamEx() {
		try {
			FileInputStream fis = new FileInputStream("screen.png");
				FileOutputStream fos = new FileOutputStream("test.png");
			int data = 0;
			while( (data = fis.read()) != -1) {
//				System.out.print((char)data);
				fos.write(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
