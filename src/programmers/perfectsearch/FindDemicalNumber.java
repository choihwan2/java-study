package programmers.perfectsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FindDemicalNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String input = bf.readLine();
		int[] arr = new int[input.length()];
		ArrayList<Integer> demicArr = new ArrayList<>();
		demicArr.add(2);
		
		for(int i =0; i<input.length(); i++) {
			arr[i] = Character.getNumericValue((input.charAt(i))); 
		}
		
		for(int i = 3; i< Math.pow(10,input.length()); i++) {
			
		}
		
	}

}
