class Solution {
    public int numDecodings(String s) {
        
        if(s.charAt(0) == '0') return 0;
        
        int iMinus2 = 1;
        
        int iMinus1 = s.charAt(0) == '0' ? 0 : 1;
        
        for(int i=2; i<s.length()+1; i++) {
            int curr = 0;
            if(s.charAt(i-1) != '0') {
                curr = iMinus1;
            }
            
            int lastTwo = Integer.valueOf(s.substring(i-2, i));
            if(lastTwo >= 10 && lastTwo <=26) {
                curr += iMinus2;
            }
            iMinus2 = iMinus1;
            iMinus1 = curr;
        }
        
        return iMinus1;
     }
}