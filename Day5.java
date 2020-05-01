class Solution {
    public int maxProfit(int[] prices) {        
        int n = prices.length;        
        if(n == 0)
            return 0;
        int sum = 0;
        int bought = prices[0];
        
        for(int i=0;i<n-1;i++){
            if(prices[i] > prices[i+1]){
                // sell
                int temp = prices[i] - bought;
                if(temp > 0)
                    sum += temp;
                bought = prices[i+1];
            }
        }
        
        int temp = prices[prices.length-1] - bought;
        if(temp > 0)
            sum += temp;
        
        return sum;
    }
}