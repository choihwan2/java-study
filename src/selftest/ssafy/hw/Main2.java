package selftest.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main2 {
    static int [] parents;
    static int [] rank;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int n = Integer.parseInt(st.nextToken()); // 사람 수
        int m = Integer.parseInt(st.nextToken()); // 쌍의 수
        
        parents = new int[n+1];
        rank = new int[n+1];   // 트리의 깊이를 측정
        
        for(int i = 1; i<=n; i++) {
            parents[i] = i;
        }
        
        for(int i = 0; i<m; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken()); 
            union(a,b);
        }
        
        int cnt = 0;
        for(int i = 1; i<=n; i++) {
            if(i == parents[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    
    public static int find(int x) {
        if(x == parents[x]) {
            return x;
        }
        parents[x] = find(parents[x]);
        return parents[x];
    }
    
    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
//        parents[px] = py;
        if(rank[px]<rank[py]) {  // 트리의 깊이를 서로 비교해서 작은것을 큰것아래에 붙인다.(트리의 깊이 최소화)
            parents[px] = py;  
        }
        else {
            parents[py] = px;
            if(rank[px] == rank[py]) {
                rank[px]++;
            }
        }
    }
 
}