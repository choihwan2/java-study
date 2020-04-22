package backjoon.algorithm.bruteforce;

import java.util.*;


public class Test03{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        ArrayList<People> peoples = new ArrayList<People>();
        int num = scanner.nextInt();
        for(int i = 0; i< num; i++){
            int weight = scanner.nextInt();
            int height = scanner.nextInt();
            peoples.add(new People(weight,height));
        }
        System.out.println(solution(peoples));
    }
    
    public static StringBuffer solution(ArrayList<People> peoples){
        for(int i = 0; i < peoples.size(); i++){
            for (int j = 0; j < peoples.size(); j++){
                if(peoples.get(i).w < peoples.get(j).w && peoples.get(i).h < peoples.get(j).h){
                    peoples.get(i).lvl++;
                }
            }
        }
        StringBuffer str = new StringBuffer();
        for(int i = 0; i < peoples.size() -1; i++){
            str.append(peoples.get(i).lvl + " ");
        }
        str.append(peoples.get(peoples.size() -1).lvl);
        return str;
    }
}
class People{
    int w;
    int h;
    int lvl = 1;
    People(int w, int h){
        this.w = w;
        this.h = h;
    }
}
