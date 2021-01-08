class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        if(numRows == 2) {
            for(int i=0; i<s.length(); i=i+2) {
                result.append(s.charAt(i));
            }
            for(int i=1; i<s.length(); i=i+2) {
                result.append(s.charAt(i));
            }
        } else {
            int diff1 = numRows + numRows - 2;
            int diff2=0;
            for(int i=0; i<numRows; i++) {
                int current=i;
                while(current < s.length()) {
                    if(diff1!=0 && current < s.length()) {
                        result.append(s.charAt(current));
                        current = current + diff1;
                    }
                    
                    if(diff2!=0 && current < s.length()) {
                        result.append(s.charAt(current));
                        current = current + diff2;
                    }
                    
                }
                diff1 -=2;
                diff2 +=2;
            }
        }
        return result.toString();
    }
}