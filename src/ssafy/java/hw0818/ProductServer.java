package ssafy.java.hw0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ProductServer {

	ServerSocket ss;
	String host = "localhost";
	int port = 8400;

	public static void main(String[] args) {
		ProductServer server = new ProductServer();
		server.startServer();
	}

	private void startServer() {
		try {
			ss = new ServerSocket(port);
			System.out.println("서버가 실행되었습니다.");
			Socket s = ss.accept();
			System.out.println("클라이언트가 접속하였습니다.");
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String msg = "";
			while ((msg = br.readLine()) != null) {
				System.out.println("From Client msg : " + msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
