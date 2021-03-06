class Solution {
    public int numWays(int n, int k) {
        if(n==1) return k;
        if(n==2) return k*k;
        
        int lastBut1 = k;
        int last = k*k;
        
        for(int i=3; i<=n; i++) {
            
            int temp = (k-1)*(lastBut1 + last);
            lastBut1 = last;
            last = temp;
        }
        return last;
    }
}