package selftest.java;

public class MobileTest {

	public static void main(String[] args) {
		Mobile mobile[] = new Mobile[2];
		mobile[0] = new Ltab("Ltab", 500, "AP-01");
		mobile[1] = new Otab("Otab", 1000, "AND-20");
		
		System.out.println(mobile[0]);
		System.out.println(mobile[1]);
		System.out.println("10분 충전");
		mobile[0].charge(10);
		mobile[1].charge(10);
		System.out.println(mobile[0]);
		System.out.println(mobile[1]);
		System.out.println("5분 충전");
		mobile[0].operate(5);
		mobile[1].operate(5);
		System.out.println(mobile[0]);
		System.out.println(mobile[1]);
	}

}
