package programmers.practice;

public class Year2016 {

}

class Solution {
  public String solution(int a, int b) {
      String[] days = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
      //0 FRI, 1 SAT, 2 SUN, 3 MON, 4 TUE, 5 WED, 6 THU
      int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};
      int diff = 0;
      for(int i = 1; i<a; i++){
          diff += month[i-1];
      }
      diff += b-1;

      String answer = days[diff%7];
      return answer;
  }
}