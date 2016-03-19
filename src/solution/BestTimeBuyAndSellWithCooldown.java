package solution;


/**
 * 描述: 
 *
 */

public class BestTimeBuyAndSellWithCooldown {

	 public int maxProfit(int[] prices) {
	      int len = prices.length;
	      
	      if(len == 0)
		        return 0;
	      
	      int[] cool = new int[len];
	      int[] buy = new int[len];
	      int[] sell = new int[len];
	      cool[0] = 0;
	      buy[0] = 0 - prices[0];
	      sell[0] = 0;
	      
	      int i =1;
	      while(i < len){
	    	  cool[i] = max(cool[i-1], sell[i-1]);
	    	  buy[i] = max(buy[i-1], cool[i-1] - prices[i]);
	    	  sell[i] = buy[i-1] + prices[i];
	    	  
	    	  i++;
	      }
	      
	      return max(cool[len-1], sell[len-1]);
	      
	 }
	 
	 private int max(int a, int b){
		 return a >b ? a : b;
	 }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new BestTimeBuyAndSellWithCooldown().maxProfit(new int[]{3,1,5000,1,2}));

	}

}

