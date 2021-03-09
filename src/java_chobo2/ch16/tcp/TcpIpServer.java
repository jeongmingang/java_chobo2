package java_chobo2.ch16.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TcpIpServer {
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(7777);
			System.out.printf("%tF 서버가 준비되었습니다.%n", new Date());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			System.out.printf("%tF 요청을 기다립니다..%n", new Date());
			
			try {
				Socket socket = ss.accept();
				
				System.out.printf("%tF %s로부터 연결 요청이 들어왔습니다.%n",
						new Date(),
						socket.getInetAddress());
				
				//out 스트림 생성
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				//requst한 클라이언트에게 전달
				dos.writeUTF("[Notice] test Message1 from Server");
				System.out.printf("%tF 데이터를 전송했습니다.%n", new Date());
				
				//스트림과 소켓을 닫아준다.
				dos.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
