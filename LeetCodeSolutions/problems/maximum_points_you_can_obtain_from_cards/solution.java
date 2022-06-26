class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length-k;
        int sum = 0, totalSum = 0, curr=0;
        for(int i=0; i<n; i++) curr += cardPoints[i];
        sum = curr;
        for(int i=n; i<cardPoints.length; i++) {
            curr += cardPoints[i]-cardPoints[i-n];
            sum = Math.min(sum, curr);
        }
        
        for(int num : cardPoints) totalSum += num;
        return totalSum-sum;
    }
}