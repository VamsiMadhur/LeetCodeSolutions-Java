class Solution {
    static final int MOD = 1000000007; 
    public int numOfWays(int n) {
        long x=6, y=6, tempX=0;
        //RBR form (6 ways), RBG form(6 ways)
        for(int i=1; i<n; i++) {
            tempX =(3*x)+(y<<1) ;
            y = (x+y)<<1;
            x = tempX;
            x = x%MOD;
            y = y%MOD;
        }
        return (int)(x+y)%MOD;
        
    }
    
}