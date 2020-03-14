package softmaestro.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test01 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		System.out.println(solution(Integer.parseInt(a)));

	}

	public static String solution(int a) {
		String answer = "";
		StringBuilder str = new StringBuilder();
		if( a%2 == 0) {
			int num_length = a/2;
			for(int i =0; i<num_length;i++) {
				str.append("1");
			}
		}else {
			str.append("7");
			a-=3;
			int num_length = a/2;
			for(int i =0; i<num_length;i++) {
				str.append("1");
			}
		}
		answer = str.toString();

		return answer;
	}

}
