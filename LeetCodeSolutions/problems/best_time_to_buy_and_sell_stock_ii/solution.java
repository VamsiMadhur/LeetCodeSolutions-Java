class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyPrice = prices[0];
        int sellPrice = 0;
        for(int i=1; i<prices.length; i++) {
            if(sellPrice==0 && buyPrice > prices[i]) {
                buyPrice = prices[i];
            } else if(sellPrice < prices[i]) {
                sellPrice = prices[i];
            } else {
                profit += (sellPrice - buyPrice);
                sellPrice = 0;
                buyPrice = prices[i];
            }
        }
        if(sellPrice != 0) {
            profit += (sellPrice - buyPrice);
        }
        return profit;
        
    }
}