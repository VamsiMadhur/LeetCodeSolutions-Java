class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        
        int prevMin = -1, prevSecondMin = -1, prevMinColour = -1;

        for(int j=0; j<k; j++) {
            if(prevMin == -1 || costs[0][j] < prevMin) {
                prevSecondMin = prevMin;
                prevMin = costs[0][j];
                prevMinColour = j;
            } else if(prevSecondMin == -1 || costs[0][j] < prevSecondMin) {
                prevSecondMin = costs[0][j];
            }
        }
        
        for(int i=1; i<n; i++) {
            int min = -1, secondMin = -1, minColour = -1;
            for(int j=0; j<k; j++) {
                int cost = costs[i][j];
                if(j == prevMinColour) {
                    cost += prevSecondMin;
                } else {
                    cost += prevMin;
                }
                
                if(min == -1 || cost < min) {
                    secondMin = min;
                    min = cost;
                    minColour = j;
                } else if(secondMin == -1 || cost < secondMin) {
                    secondMin = cost;
                }
            }
            prevMin = min;
            prevSecondMin =secondMin;
            prevMinColour = minColour;
        }
        
        return prevMin;
    }
}