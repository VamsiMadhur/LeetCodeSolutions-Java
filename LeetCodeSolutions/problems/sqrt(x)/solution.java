class Solution {
    public int mySqrt(int x) {
        return searchIn(0,x, x);
    }
    
    //After 46340, Square value will not be in Integer range, it will be greater than ((2^32)-1). So, make sure "l" is also always less than or equals 46340.
    public int searchIn(int i, int j, int x) {
        int k = (i+j)/2;
        int l = k+1;
        if(k==46340 && ((k*k)<=x)) {
            return k;
        } else if(k<=46339 && ((k*k)<=x)) {
            if((l*l)>x) {
                return k;
            } else {
                return searchIn(k+1, j, x);
            }
        } else {
            return searchIn(0,k,x);
        }
    }
}