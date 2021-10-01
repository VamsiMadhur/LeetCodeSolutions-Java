class Solution {
    public int numTrees(int n) {
        int[] result = new int[n+1];
        result[0] = 1;
        result[1] = 1;
        for(int i=2; i<=n; i++) {
            int sum = 0;
            for(int j=1; j<=i; j++) {
                sum += (result[j-1] * result[i-j]);
            }
            result[i] = sum;
        }
        return result[n];
    }
}