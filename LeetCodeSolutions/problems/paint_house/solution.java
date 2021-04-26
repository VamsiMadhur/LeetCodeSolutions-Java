class Solution {
    public int minCost(int[][] costs) {
        int cost = 0;
        int red = costs[0][0];
        int blue = costs[0][1];
        int green = costs[0][2];
        
        for(int i=1; i<costs.length; i++) {
            int tempred =  costs[i][0] + Math.min(blue, green);
            int tempblue = costs[i][1] + Math.min(red, green);
            int tempgreen = costs[i][2] + Math.min(red, blue);
            
            red = tempred;
            blue = tempblue;
            green = tempgreen;
        }
        
        return Math.min(red, Math.min(blue, green));
    }
}