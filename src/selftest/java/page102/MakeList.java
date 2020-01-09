package selftest.java.page102;

import java.util.ArrayList;

public class MakeList {
	ArrayList<Integer> list;

	public MakeList() {
		list = new ArrayList<Integer>();
	}

	public void makeArrayList(int size) {
		for (int i = 0; i < size; i++) {
			list.add((int) (Math.random() * 100) + 1);
		}
	}

	public double getAverage() {
		double avg = 0.0;
		for (int i = 0; i < list.size(); i++) {
			avg += list.get(i);
		}
		return Math.round(avg / list.size() * 100) / 100;
	}

	public ArrayList<Integer> getList() {
		return list;
	}
}
