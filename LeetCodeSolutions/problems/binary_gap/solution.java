class Solution {
    public int binaryGap(int n) {
        int result = 0, curr=1;
        while(n!=0) {
            if((n&1) == 1) break;
            n>>=1;
        }
        if(n==0 || n==1) return 0;
        while(n!=0) {
            if((n&1) == 0) curr++;
            else {
                result = Math.max(curr, result);
                curr=1;
            }
            n>>=1;
        }
        return result;
    }
}