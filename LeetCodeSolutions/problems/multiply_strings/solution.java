class Solution {
    public String multiply(String num1, String num2) {
        if(num1 ==null || num2 == null) {
            return null;
        }
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int l1 = num1.length();
        int l2 = num2.length();
        int result[] = new int[l1+l2];
        
        for(int i=0; i<=l1-1; i++) {
            int currentI = num1.charAt(l1-1-i) - '0';
            int carry = 0;    
            for(int j=0; j<=l2-1; j++) {
                int currentJ = num2.charAt(l2-1-j) - '0';
                int curResult = (currentI * currentJ)+carry+result[i+j];
                result[i+j] = (curResult%10);
                carry = (curResult)/10;
            }
            if(carry != 0) {
                result[i+l2] = carry;
            }
        }
        
        String resultString = "";
        for(int i=0; i<l1+l2; i++) {
            resultString = result[i] + resultString;
        }
        while(resultString.charAt(0) == '0') {
            resultString = resultString.substring(1);
        }
        return resultString;
    }
}