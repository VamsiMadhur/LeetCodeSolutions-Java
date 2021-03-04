class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num<=1) {
            return false;
        }
        
        int sum = 1;
        int i=2;
        for(; i*i<num; i++) {
            if(num%i==0) {
                sum += i;
                sum += (num/i);
            }
            if(sum>num) {
                return false;
            }
        }
        if(i*i==num) {
            sum+= i;
        }
        
        return sum==num;
    }
}