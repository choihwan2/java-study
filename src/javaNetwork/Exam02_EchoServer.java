package javaNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Exam02_EchoServer {
	public static void main(String[] args) {
		// 1. 서버프로그램이기 때문에 ServerSocket 이 필요
		try {
			ServerSocket server = new ServerSocket(6020); // client 의 접속을 받기위해 존재
			System.out.println("서버가 기동되었습니당!");
			// 2. 클라이언트가 접속할 수 있게 ServerSocket 에 accept() 호출
			Socket s = server.accept(); // client 와 연결되어 데이터 통신을 하기 위해 존재
			// 3. client로부터 데이터를 받아야 해요.. 그리고 받은 데이터를 그대로 다시 보내준다.
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

			// 데이터를 보내기 위해서는 PritnerWriter 이용
			PrintWriter pr = new PrintWriter(s.getOutputStream());

			String msg = "";
			while (true) {
				// 클라이언트가 보내준 데이터를 받아요!
				msg = br.readLine(); // 아직 읽을게 없다면 대기한다. + 비정상 종료 됐을때 exception
				if (msg == null || msg.equals("@EXIT")) {
					// client 쪽이 연결을 끊을경우 null 이 보내진다.
					break;
				}
				pr.println(msg);
				pr.flush();
			}
			if(pr != null) pr.close();
			if(br != null) br.close();
			if(s != null) s.close();
			if(server != null) server.close();
			
			System.out.println("서버가 종료되엇어요!");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
