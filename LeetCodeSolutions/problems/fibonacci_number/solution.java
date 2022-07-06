class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        int a=0, b=1, temp=0;
        for(int i=2; i<=n; i++) {
            temp = a+b;
            a = b;
            b = temp;
        }
        return b;
    }
}