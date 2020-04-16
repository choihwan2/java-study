package javaNetwork;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

// 서버쪽 프로그램
// 클라이언트가 접속하면 현재 시간을 알안새서 클라이언트에게 전송하는 서버 프로그램
public class Exam01_DataServer {
	public static void main(String[] args) {
		// 1. 서버프로그램 이니깐 클아이언트의 접속을 기다려야 해요!
		// 클라이언트의 Socket 접속을 기다리는 ServerSocket 이 필요해요!
		// 적당한 port 번호를 이용해서 ServerSocket 객체를 생성
		try {
			ServerSocket server =  new ServerSocket(5556);
			System.out.println("서버가 생성되었어요!");
			// 2. 클라이언트의 접속을 기다리기 위한 method 를 호출
			Socket s = server.accept(); // blocking method 클라이언트가 접속할때 까지 대기!
			// 3. 소켓이생성되면 데이터 입출력을 위해 Stream 을 생성해요!
			String data = (new Date()).toLocaleString(); // 현재시간 구해요!
			PrintWriter out = new PrintWriter(s.getOutputStream());
			
			out.println(data);
			out.flush();
			out.close();	// stream 을 닫고
			s.close();		// client 와 연결된 socket을 닫고
			server.close();	// serversocket 을 닫아요!
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
