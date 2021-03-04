class Solution {
    private static int HALF_INT_MIN = -1073741824;
    
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        boolean negative = true;
        if(dividend > 0) {
            dividend = -dividend;
            negative = !negative;
        }
        if(divisor > 0) {
            divisor = -divisor;
            negative = !negative;
        }
       
        int maxBit = 0;
        while(divisor >= HALF_INT_MIN && divisor + divisor >= dividend) {
            maxBit += 1;
            divisor += divisor ;
        }
       
        int quotient = 0;
        
        for(int bit = maxBit; bit>=0; bit--) {
            if(divisor >= dividend) {
                quotient -= (1<<bit);
                dividend -= divisor;
            }
            divisor = (divisor+1) >> 1;
        }
        if(negative) {
            quotient = -quotient;
        }
        return quotient;
    }
}