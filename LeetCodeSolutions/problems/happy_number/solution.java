class Solution {
    public boolean isHappy(int n) {
        if(n==1 || n==7) {
            return true;
        } else if(n<10) {
            return false;
        }
        int result = 0;
        while(n!=0) {
            int curr = n%10;
            result += (curr*curr);
            n/=10;
        }
        return isHappy(result);
    }
}