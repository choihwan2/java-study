package backjoon.algorithm.que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Problem1966{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(bf.readLine());
        for(int i=0; i<caseNum; i++){
            Queue<Page> que = new LinkedList<>();
            Queue<Page> wait_que = new LinkedList<>();
            String[] input = bf.readLine().split(" ");
            
            int target_pos = Integer.parseInt(input[1]);
            
            int pos = 0;
            int answer = 0;
            StringTokenizer str_k = new StringTokenizer(bf.readLine());
            while(str_k.hasMoreElements()){
                que.add(new Page(Integer.parseInt(str_k.nextToken()),pos++));
            }
            
            while(!que.isEmpty()){
            	int max = que.peek().imp;
            	boolean isMax = true;
                for(Page page : que){
                    if(max < page.imp){
                        isMax = false;
                        break;
                    }
                }
                if(!isMax) {
                	wait_que.add(que.poll());
                	continue;
                }

                if(!que.isEmpty() && que.peek().pos != target_pos){
                    answer++;
                    que.poll();
                }else if(!que.isEmpty() && que.peek().pos == target_pos){
                    answer++;
                    System.out.println(answer);
                    break;
                }
                while(!wait_que.isEmpty()){
                    que.add(wait_que.poll());
                }
            }
            
            
        }
    }
}
class Page{
    int imp;
    int pos;
    Page(int imp, int pos){
        this.imp = imp;
        this.pos = pos;
    }
}
