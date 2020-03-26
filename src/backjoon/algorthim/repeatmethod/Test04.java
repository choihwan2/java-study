package backjoon.algorthim.repeatmethod;


public class Test04 {
	static int answer = 0;
	static StringBuffer stringBuffer = new StringBuffer();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hanoi(3, 1, 3, 2);
		System.out.println(answer);
		System.out.println(stringBuffer);
	}

	public static void hanoi(int num, int from, int to, int other) {
		if (num == 0)
			return;
		hanoi(num - 1, from, other, to);
		stringBuffer.append("원반[" + num + "]은" + from + " " + to + "\n");
		hanoi(num - 1, other, to, from);
		answer++;
	}

}
