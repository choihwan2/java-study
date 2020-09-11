package baekjoon.algorithm.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_17480_개구쟁이_준석이_종성 {
	static int N;
	static TreeSet<String> ts;
	static int[] junAlpha;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ts = new TreeSet<String>();
		N = Integer.parseInt(br.readLine());
		junAlpha = new int[26];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int len = 0;
		for(int i = 0; i<N; i++) {
			char a = stk.nextToken().charAt(0);
			int n = Integer.parseInt(stk.nextToken());
			junAlpha[a-'a'] = n;
			len += n;
		}
		
		StringBuilder word = new StringBuilder().append(br.readLine());
		TreeSet<String> strs = new TreeSet<String>();
		for(int i = 0; i<=word.length()-len; i++) {
			int[] check = new int[26];
			String substr = word.substring(i, i+len);
			for(int k = i; k<i+len; k++) {
				char c = word.charAt(k);
				check[c - 'a']++;
			}
			boolean flag = true;
			for(int k = 0; k<26; k++) {
				if(check[k] != junAlpha[k]) {
					flag = false;
				}
			}
			if(flag) {
				strs.add(substr);
			}
		}
		for(String str : strs) {
			divide(str, str, 0, str.length());
		}
		System.out.println(ts.size());
		
	}
	
	static void divide(String word, String str, int s, int e) {
		if(str.length() <= 2) {
			ts.add(word);
			return;
		}
		
		if(str.length()%2 == 0) {
			int n = str.length();
			String str1 = str.substring(0, n/2);
			String str2 = str.substring(n/2, n);
			
			StringBuilder sb1 = new StringBuilder();
			sb1.append(str1);
			
			StringBuilder sb2 = new StringBuilder();
			sb2.append(str2);
			
			//첫번째를 선택
			StringBuilder newWord = new StringBuilder(word);
			newWord.replace(s, e/2, sb1.reverse().toString());
			divide(newWord.toString(), str2, e/2, e);
			//두번째를 선택
			newWord = new StringBuilder(word);
			newWord.replace(e/2, e, sb2.reverse().toString());
			divide(newWord.toString(), str1, s, e/2);
		}else {
			//str1>str2
			int n = str.length();
			String str1 = str.substring(0, n/2+1);
			String str2 = str.substring(n/2+1, n);
			StringBuilder sb1 = new StringBuilder();
			sb1.append(str1);
			
			StringBuilder sb2 = new StringBuilder();
			sb2.append(str2);
			
			//첫번째를 선택
			StringBuilder newWord = new StringBuilder(word);
			newWord.replace(s, s+n/2+1, sb1.reverse().toString());
			divide(newWord.toString(), str2, s+n/2+1, e);
			//두번째를 선택
			newWord = new StringBuilder(word);
			newWord.replace(s+n/2+1, e, sb2.reverse().toString());
			divide(newWord.toString(), str1, s, s+n/2+1);
			
			//str1<str2
			str1 = str.substring(0, n/2);
			str2 = str.substring(n/2, n); 
			
			sb1 = new StringBuilder();
			sb1.append(str1);
			
			sb2 = new StringBuilder();
			sb2.append(str2);
			
			//첫번째를 선택
			newWord = new StringBuilder(word);
			newWord.replace(s, s+n/2, sb1.reverse().toString());
			divide(newWord.toString(), str2, s+n/2, e);
			//두번째를 선택
			newWord = new StringBuilder(word);
			newWord.replace(s+n/2, e, sb2.reverse().toString());
			divide(newWord.toString(), str1, s, s+n/2);
		}
	}
}
