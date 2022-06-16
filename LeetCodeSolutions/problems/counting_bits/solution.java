class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        if(n == 0) return result;
        result[1] = 1;
        if(n==1) return result;
        
        int count=1, next=2;
        for(int i=2; i<=n; i++) {
            if(i== next)  {
                count<<=1;
                next<<=1;
            }
            result[i] = result[i-count]+1;
        }
        return result;
    }
}