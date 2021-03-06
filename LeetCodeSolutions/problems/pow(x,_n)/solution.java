class Solution {
    public double myPow(double x, int n) {
        if(n < 0) {
            n = -n;
            x = 1/x;
        }
        return fastPow(x,n);
    }
    
    public double fastPow (double x, int n) {
        if(n==0) {
            return 1;
        }
        double half = fastPow(x, n/2);
        if(n%2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}