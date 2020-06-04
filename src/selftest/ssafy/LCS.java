package selftest.ssafy;

public class LCS {
    public static void main(String[] args) {
        System.out.println(getLCSLength("ABC","ABC"));
    }

    private static int getLCSLength(String a, String b) {
        int answer = 0;
        int[][] lcs = new int[a.length() + 1][b.length() + 1];
        for(int i = 1; i<= a.length(); i++){
            for(int j = 1; j<= b.length(); j++){
                if(a.charAt(i - 1) == b.charAt(j -1)){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                }else{
                    lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
                }
            }
        }

//        for(int i = 0; i< lcs.length; i++){
//            for(int j = 0; j<lcs[i].length; j++){
//                answer = Math.max(lcs[i][j],answer);
//            }
//        }

        answer = lcs[lcs.length -1][lcs[0].length -1];

        return answer;
    }
}
