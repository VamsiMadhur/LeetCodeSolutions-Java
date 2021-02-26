class Solution {
    public String convertToBase7(int num) {
        if(num==0) {
            return "0";
        }
        boolean isPositive = true;
        if(num < 0) {
            isPositive = false;
            num = -num;
        }
        StringBuffer result = new StringBuffer();
        
        while(num!=0) {
            int curr = num%7;
            num/=7;
            result.append(curr);
        }
        if(!isPositive) {
            result.append("-");
        }
        return result.reverse().toString();
    }
}