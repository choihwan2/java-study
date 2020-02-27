package programmers.stack.que;
import java.util.Stack;

public class StockPrice {
	public static void main(String[] args) {
	}
	class Solution {
	    public int[] solution(int[] prices) {
	        int[] answer = new int[prices.length];
	        Stack<Price> stack = new Stack<Price>();
	        for(int i=0; i<prices.length; i++){
	            for(Price price : stack){
	                price.time++;
	            }
	            while(!stack.isEmpty() && stack.peek().price > prices[i]){
	                answer[stack.peek().pos] = stack.pop().time;
	            }
	            stack.push(new Price(prices[i],i));
	        }
	        while(!stack.isEmpty()){
	            answer[stack.peek().pos] = stack.pop().time;
	        }
	        return answer;
	    }
	}
	class Price{
	    int price;
	    int pos;
	    int time = 0;

	    Price(int price, int pos){
	        this.price = price;
	        this.pos = pos;
	    }
	}
}

