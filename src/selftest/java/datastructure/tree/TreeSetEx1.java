package selftest.java.datastructure.tree;

import java.util.TreeSet;

public class TreeSetEx1 {

	public static void main(String[] args) {
		TreeSet<String> set = new TreeSet<>();
		
		String from = "b";
		String to = "d";
		
		set.add("abc");
		set.add("aliean");
		set.add("bat");
		set.add("car");
		set.add("Car");
		set.add("disc");
		set.add("dance");
		set.add("dZZZ");
		set.add("dzzzz");
		set.add("elephant");
		set.add("elevator");
		set.add("fan");
		set.add("flower");
		
		System.out.println(set);
		
		System.out.println("range search : from " + from + " to " + to);
		System.out.println("result1 : " + set.subSet(from, to));
		System.out.println("result2 : " + set.subSet(from, to + "zzz"));
		
	}

}
