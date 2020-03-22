package selftest.java.datastructure.stack;

public class Qestion3 {
	public static void main(String[] args) {
		
	}
	
}

class MyStack{
	int max = 1000;
	int[] stk = new int[max];
	int a_ptr = 0;
	int b_ptr = max - 1;
	
	public void a_push(int input) {
		if (a_ptr < b_ptr) {
			stk[a_ptr++] = input;
		}else {
		}
	}
	
}
