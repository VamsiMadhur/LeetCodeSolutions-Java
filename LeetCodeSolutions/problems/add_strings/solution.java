class Solution {
    public String addStrings(String num1, String num2) {
        StringBuffer result = new StringBuffer();
        int i=num1.length()-1;
        int j=num2.length()-1;
        int borrow = 0;
        while(i>=0 || j>=0) {
            int a = i<0 ? 0 : num1.charAt(i) - '0';
            int b = j<0 ? 0 : num2.charAt(j) - '0';
            int current = (a+b+borrow);
            borrow = current/10;
            result.append(current%10);
            i--;
            j--;
        }
        if(borrow != 0) {
            result.append(borrow);
        }
        return result.reverse().toString();
    }
}