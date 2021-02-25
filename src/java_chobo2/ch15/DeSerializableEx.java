package java_chobo2.ch15;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DeSerializableEx {

	/**
	 * 역직렬화 예제
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 *
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String fileName = "UserInfo.ser";

		try (FileInputStream fis = new FileInputStream(fileName);
				BufferedInputStream bis = new BufferedInputStream(fis);
				ObjectInputStream ois = new ObjectInputStream(bis)) {

			// 객체를 읽을때는 출력한 순서와 일치해야함
			UserInfo u1 = (UserInfo) ois.readObject();
			UserInfo u2 = (UserInfo) ois.readObject();
			ArrayList<UserInfo> list = (ArrayList) ois.readObject();
			
			System.out.println(u1);
			System.out.println(u2);
			System.out.println(list);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	} // main
} // class
