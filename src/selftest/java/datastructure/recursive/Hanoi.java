package selftest.java.datastructure.recursive;

public class Hanoi {

	public static void main(String[] args) {
		move(3, 1, 3);
	}

	static void move(int no, int x, int y) {
		// 그룹을 중간으로
		// 한개를 목표로
		// 그룹을 목표로
		if (no > 1) 
			move(no - 1, x, 6-x-y);
			System.out.println(no + "를" + x + "에서" + y + "로 옮깁니다");
		if (no > 1)
			move(no - 1, 6-x-y, x);
	}

}
