class Solution {
    
    public boolean isCharacterOrDigit(char s) {
        if(((s>='A')&&(s<='Z')) || ((s>='a') &&(s<='z')) || ((s>='0')&&(s<='9'))) {
            return true;
        }
        return false;
    }
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i<j) {
            char si = s.charAt(i);
            char sj = s.charAt(j);
            
            if(!isCharacterOrDigit(si)) {
                i++;
            } else if(!isCharacterOrDigit(sj)) {
                j--;
            } else {
                if(si>='A' && si<='Z') {
                    si = (char)(si-'A'+'a');
                }
                if(sj>='A' && sj<='Z') {
                    sj = (char)(sj-'A'+'a');
                }
                if(si!=sj) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}