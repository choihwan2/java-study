package selftest.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *  내 생각에는 기준점을 잡고 오른족 왼쪽으로 나눈다.
 *  먼저 왼족이나 오른쪽 남아있는 개수가 K보다 작으면 1을 올린다음 남은 차이만큼 반대쪽의 개수를 빼주기.
 *  K보다 크면 그냥 나눠서 계산 나머지 남으면 +1
 */

public class Test06 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String first = bf.readLine();
		StringTokenizer strToken = new StringTokenizer(first);
		int num = Integer.parseInt(strToken.nextToken());
		int K = Integer.parseInt(strToken.nextToken()) - 1;	// 범위 보다 1개 적게 줘야지 왼쪽 오른쪽으로 나눴을때의 계산이 편해진다.
		int[] arr = new int[num];
		int answer = 0;
		
		String values = bf.readLine();
		strToken = new StringTokenizer(values);
		int temp =0;
		while (strToken.hasMoreElements()) {
			arr[temp++] = Integer.parseInt(strToken.nextToken());
		}
		
		int min = arr[0];  
		int pos = 0;	//최소값의 위치를 찾는다.
		for(int i = 1; i< arr.length; i++) {
			if(min > arr[i]) {
				min = arr[i];
				pos = i;
			}
		}
		
		int left = pos;	//왼쪽 갯수
		int right = arr.length - pos -1;	//오른쪽 갯수
		
		answer += left / K;
		int rest_L = left%K;
		answer += right / K;
		int rest_R = right%K;
		if(rest_L + rest_R > K) {
			answer += 2;
		}else {
			answer++;
		}
		if(rest_L + rest_R ==0) {
			answer--;
		}
		
		
		System.out.println(answer);
		
		
		
		
		
	}

}
