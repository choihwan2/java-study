package selftest.java.page102;

public class ListTest01 {

	public static void main(String[] args) {
		MakeList makeList = new MakeList();
		makeList.makeArrayList(Integer.parseInt(args[0]));
		for (int i = 0; i < makeList.getList().size(); i++) {
			System.out.println(makeList.getList().get(i));
		}
		System.out.println(makeList.getAverage());
	}

}
