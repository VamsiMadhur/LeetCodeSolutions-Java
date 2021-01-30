class Solution {
    public int trailingZeroes(int n) {
        int val = n;
        int dig = 5;
        int result = 0;
        while(dig<=val) {
            result += (val/dig);
            dig*=5;
        }
        return result;
    }
}