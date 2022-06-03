class Solution {
    private static int MOD = 1000000007;
    public int countVowelPermutation(int n) {
        if(n==1) return 5;
        long a=1,e=1,i=1,o=1,u=1;
        long ta=0, te=0, ti=0, to=0, tu=0;
        for(int k=1; k<n; k++) {
            ta = u+e+i;
            te = a+i;
            ti = e+o;
            to = i;
            tu = i+o;
            a=ta%MOD; e=te%MOD; i=ti%MOD; o=to%MOD; u=tu%MOD;
        }
        return (int) ((a+e+i+o+u)%MOD);
    }
}