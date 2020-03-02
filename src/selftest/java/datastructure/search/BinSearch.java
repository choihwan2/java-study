package selftest.java.datastructure.search;

import java.util.Arrays;
import java.util.Scanner;

public class BinSearch {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		
		int num = scanner.nextInt();
		int[] x = new int[num];
		
		System.out.println("값을 입력하세요");
		
		for(int i =0; i<num; i++) {
			x[i] = scanner.nextInt();
		}
		Arrays.sort(x);
		System.out.println(Arrays.toString(x));
		System.out.print("검색할 값: ");
		
		int ky = scanner.nextInt();
		int idx = -1;
		printBinSearch(x,num,ky);
		
		if(idx == -1) {
			System.out.println("그런 값이 없습니다.");
		}else
			System.out.println(ky + "은 x[" + idx + "]");

	}

	static int binSearch(int[] a, int n, int key) {
		int pl = 0;
		int pr = n -1;
		
		do {
			int pc = (pl + pr) /2;
			if(a[pc] == key)
				return pc;
			else if(a[pc] < key)
				pl = pc +1;
			else
				pr = pc -1;
		}while(pl <= pr);
		
		return -1;
	}
	
	static int seqSearchSen(int[] a, int n, int key) {
		for(int i =0; i<n; i++) {
			if(a[i] == key) {
				return i;
			}
		}
		return -1;
	}
	
	static int searchIdx(int[] a, int n, int key, int[] idx) {
		int j = 0; 
		for(int i = 0; i< n; i++) {
			if(a[i] == key) {
				idx[j++] = i;
			}
		}	
		return j;
	}
	
	static int seqSearchEx(int[] a, int n, int key) {
		System.out.print("   |");
		for (int k = 0; k < n; k++)
			System.out.printf("%4d", k);
		System.out.println();

		System.out.print("---+");
		for (int k = 0; k < 4 * n + 2; k++)
			System.out.print("-");
		System.out.println();

		for (int i = 0; i < n; i++) {
			System.out.print("   |");
			System.out.printf(String.format("%%%ds*\n", (i * 4) + 3), "");
			System.out.printf("%3d|", i);
			for (int k = 0; k < n; k++)
				System.out.printf("%4d", a[k]);
			System.out.println("\n   |");
			if (a[i] == key)
				return i; // 검색성공
		}
		return -1; // 검색실패
	}
	
	static void printBinSearch(int[] a, int n, int key) {
		System.out.printf("    |");
		for(int i = 0; i< n; i++) {
			System.out.printf("%3d",a[i]);
		}
		System.out.println();
		System.out.println("---+-----------------");

		int ps = 0;
		int pl = n-1;
		
		while(ps<= pl) {
			int pc = (ps + pl) /2;
			System.out.print("   |");
			if (ps != pc)
				System.out.printf(String.format("%%%ds<-%%%ds+", (ps * 4) + 1, (pc - ps) * 4), "", "");
			else
				System.out.printf(String.format("%%%ds<-+", pc * 4 + 1), "");
			if (pc != pl)
				System.out.printf(String.format("%%%ds->\n", (pl - pc) * 4 - 2), "");
			else
				System.out.println("->");
			System.out.printf("%3d|", pc);
			for (int k = 0; k < n; k++)
				System.out.printf("%4d", a[k]);
			System.out.println("\n   |");
			if(a[pc] == key) {
				System.out.println(key +"는 x[" + pc + "] 에 있습니다.");
				return;
			}else if(a[pc] < key) {
				ps = pc + 1;
			}else if(a[pc] > key) {
				pl = pc - 1;
			}
		}
		
	}

}
