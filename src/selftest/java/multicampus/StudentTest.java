package selftest.java.multicampus;

public class StudentTest {

	public static void main(String[] args) {
		Student studentArray [] = new Student[3];
		studentArray[0] = new Student("홍길동", 15, 171, 81);
		studentArray[1] = new Student("한사람", 13, 183, 72);
		studentArray[2] = new Student("임걱정", 16, 175, 65);
		for (int i = 0; i < studentArray.length; i++) {
			System.out.println(studentArray[i]);
		}
	}

}
