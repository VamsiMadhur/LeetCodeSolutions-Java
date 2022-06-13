class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] minSum = new int[n];
        List<Integer> lastRow =  triangle.get(n-1);
        for(int i=0; i<n; i++) 
            minSum[i] = lastRow.get(i);
        
        for(int i=n-2; i>=0; i--) {
            List<Integer> currRow =  triangle.get(i);
            for(int j=0; j<=i; j++) 
                minSum[j] = Math.min(minSum[j], minSum[j+1])+currRow.get(j);
        }
        return minSum[0];
        
    }
}