class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        
        int sum = 0;
        for(int i=0; i<k; i++) {
            sum += cardPoints[i];
        }
        int result = sum;
        
        if(n==k) return result;
        
        int startIndex = n-1;
        int endIndex = k-1;

        for(int i=0; i<k; i++) {
            sum = sum - cardPoints[endIndex--] + cardPoints[startIndex--];
            result = Math.max(result, sum);
        }
        return result;
    }
}