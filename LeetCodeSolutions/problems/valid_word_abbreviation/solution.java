class Solution {
    
    public boolean isDigit(char a) {
        if(a >= 'a' && a <= 'z') {
            return true;
        }
        return false;
    }
    
    public boolean validWordAbbreviation(String word, String abbr) {
        int wi=0;
        int ai = 0;
        
        while(wi<word.length() && ai<abbr.length()) {
            char wl = word.charAt(wi);
            char al = abbr.charAt(ai);
            
            if(wl == al) {
                wi++; ai++;
            } else if(al <= '0' || al > '9') { //Number cannot start with zero
                return false;
            } else {
                int start = ai;
                while(ai<abbr.length() && (abbr.charAt(ai)>='0' && abbr.charAt(ai)<='9')) {
                    ai++;
                }
                int num = Integer.parseInt(abbr.substring(start, ai));
                
                wi += num;
            }
        }
        return wi==word.length() && ai==abbr.length();
    }
}