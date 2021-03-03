class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length()<2) {
            return true;
        }
        boolean isCapital = false;
        int i=0;
        if(Character.isLowerCase(word.charAt(0))) {
            isCapital = false;
            i=1;
        } else {
            if(Character.isLowerCase(word.charAt(1)))
                isCapital = false;
            else
                isCapital = true;
            i=2;
        }
        for(; i<word.length(); i++) {
            if(isCapital) {
                if(Character.isLowerCase(word.charAt(i))) {
                    return false;
                }
            } else {
                if(Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }      
        }
        return true;
    }
}