package javaNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// 서버쪽 프로그램
// 클라이언트가 접속하면 현재 시간을 알안새서 클라이언트에게 전송하는 서버 프로그램
/*
 * 1. 클라이언트가 데이터를 서버에 전송
 * 2. 서버가 데이터를 받아서 다시 클라이언트에게 전송
 * 3. 전송받은 데이터를 TextArea 에 출력
 * 4. 이 작업을 반복 클라이언트가 @EXIT 를 입력할때까지 반복
 */
public class Exam01_DataServer2 {
	public static void main(String[] args) {
		// 1. 서버프로그램 이니깐 클아이언트의 접속을 기다려야 해요!
		// 클라이언트의 Socket 접속을 기다리는 ServerSocket 이 필요해요!
		// 적당한 port 번호를 이용해서 ServerSocket 객체를 생성
		try {
			ServerSocket server = new ServerSocket(5556);
			System.out.println("서버가 생성되었어요!");
			// 2. 클라이언트의 접속을 기다리기 위한 method 를 호출
			while (true) {
				Socket s = server.accept(); // blocking method 클라이언트가 접속할때 까지 대기!
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				PrintWriter out = new PrintWriter(s.getOutputStream());
				String msg = br.readLine();
				out.println(msg);
				out.flush();
				if (msg.equals("@EXIT")) {
					out.close(); // stream 을 닫고
					s.close(); // client 와 연결된 socket을 닫고
					server.close(); // serversocket 을 닫아요!
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
