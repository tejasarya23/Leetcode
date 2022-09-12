class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit=0;int min=500000;
        for(int i=0;i<n;i++){
            if(prices[i]<min){
                min=prices[i];continue;
            }
            if(i!=n-1&&prices[i+1]<prices[i]){
                profit+=prices[i]-min;
                min=500000;continue;
            }
            // System.out.print(min);
            if(i==n-1&&prices[i]>min){
                profit+=prices[i]-min;
            }
        }
        return profit;
    }
}