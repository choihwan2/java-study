package programmers.school.day04;

public class EssenceTriangle {
    public int solution(int[][] triangle) {

        //[[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]
        //  1    2  3    4  5  6    7  8  9  10   11
        // n  층에서  n 만큼 더하면 자신의 왼쪽 밑 그리고 오른쪽 밑은 n+1
        int answer = 0;
        int len = 0;
        for (int i = 1; i <= triangle.length; i++) {
            len += i;
        }
        int[] triSum = new int[len + 1];
        triSum[1] = triangle[0][0];


        for (int i = 2; i <= triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++){
                triSum[i + j] = triSum[i] + triangle[i-1][j];
            }
        }
        return answer;
    }
}
