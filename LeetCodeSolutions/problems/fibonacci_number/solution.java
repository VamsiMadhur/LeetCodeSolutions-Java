class Solution {
    public int fib(int n) {
        if(n==0) {
            return 0;
        }
        int p2 = 0;
        int p1 = 1;
        for(int i=2; i<=n; i++) {
            int temp = p1 + p2;
            p2 = p1;
            p1 = temp;
        }
        return p1;
    }
}