package selftest.java.datastructure.search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysExamSearch {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		PhysData[] x = {
				new PhysData("이나영", 162, 0.3),
				new PhysData("원빈", 163, 2.0),
				new PhysData("잡스", 172, 1.3),
				new PhysData("강나영", 175, 0.8),
				new PhysData("고나영", 178, 3.3),
				new PhysData("민나영", 180, 2.3),
				new PhysData("수나영", 182, 1.7),
				new PhysData("박나영", 186, 0.9)
		};
		System.out.println("몇 cm 인 사람을 찾고 있나요? : ");
		int height = stdIn.nextInt();
		int idx = Arrays.binarySearch(x, new PhysData("", height, 0.0),PhysData.HEIGHT_ORDER);
		
		if(idx <0)
			System.out.println("없다");
		else {
			System.out.println("x[" + idx + "]에 있습니다.");
			System.out.println("찾은 데이터:" + x[idx]);
		}
		
		stdIn.close();

	}

	static class PhysData {
		private String name;
		private int height;
		private double vision;

		public PhysData(String name, int height, double vision) {
			super();
			this.name = name;
			this.height = height;
			this.vision = vision;
		}

		@Override
		public String toString() {
			return "PhysData [name=" + name + ", height=" + height + ", vision=" + vision + "]";
		}

		public static final Comparator<PhysData> HEIGHT_ORDER = new HeightOrderComparator();

		private static class HeightOrderComparator implements Comparator<PhysData> {
			@Override
			public int compare(PhysData d1, PhysData d2) {
				return (d1.height > d2.height) ? 1 : (d1.height < d2.height) ? -1 : 0;
			}
		}

	}

}
