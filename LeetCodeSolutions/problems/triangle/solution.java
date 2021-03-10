class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] minSum = new int[triangle.size()];
        List<Integer> lastRow = triangle.get(triangle.size()-1);
        for(int i=0; i<lastRow.size(); i++) {
            minSum[i] = lastRow.get(i);
        }
        
        for(int j=triangle.size()-2; j>=0; j--) {
            List<Integer> level = triangle.get(j);
            for(int i=0; i<level.size(); i++) {
                int min = Math.min(minSum[i], minSum[i+1]);
                minSum[i] = min+level.get(i);
            }
        }
        
        return minSum[0];
    }
}