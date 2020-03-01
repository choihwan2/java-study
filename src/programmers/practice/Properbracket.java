package programmers.practice;

public class Properbracket {

	public static void main(String[] args) {
		System.out.println(solution("((((())))"));
	}
	public static boolean solution(String s) {
		boolean answer = false;
		int a =0;
		for(int i =0; i<s.length(); i++) {
			if(s.charAt(i) == '(') {
				a++;
			}else {
				a--;
			}
		}
		
		if(a == 0) {
			answer = true;
		}
//		while(s.indexOf("()") >= 0){
//			s = s.replace("()", "");
//		}
//		if(s.length()>=1) {
//			answer = false;
//		}
		
		return answer;
	}

}
