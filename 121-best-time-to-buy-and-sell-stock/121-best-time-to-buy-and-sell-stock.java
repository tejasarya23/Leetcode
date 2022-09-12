class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min=500000;int profit=0;
        for(int i=0;i<n;i++){
            if(prices[i]<min){
                min=prices[i];
            }  
            // System.out.print(min);
            profit=Math.max(prices[i]-min,profit);
        }
        return profit;
    }
}