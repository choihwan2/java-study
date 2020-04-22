package backjoon.algorithm.string;
import java.util.Scanner;
public class Problem2908 {
	public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String a,b;
        a = scanner.next();
        b = scanner.next();
        StringBuilder str = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for(int i=0; i<a.length(); i++){
            str.append(a.charAt(a.length()-i-1));
        }
        for(int i=0; i<b.length(); i++){
            str2.append(b.charAt(b.length()-i-1));
        }
        a = str.toString();
        b = str2.toString();
        System.out.println(Math.max(Integer.parseInt(a),Integer.parseInt(b)));
        scanner.close();
    }
}
