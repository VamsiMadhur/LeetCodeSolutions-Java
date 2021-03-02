class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1) {
            return true;
        }
        int x = num/2;
        while (x > (num/x)) {
            x = (x + (num/x)) >> 1;
        }
        return (x * x == num);
    }
}