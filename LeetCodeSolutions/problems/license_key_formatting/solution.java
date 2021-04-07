class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuffer result = new StringBuffer();
        int count = 0;
        for(int i=S.length()-1; i>=0; i--) {
            char temp = S.charAt(i);
            if(temp != '-') {
                if(count == K) {
                    result.append("-");
                    count = 0;
                }
                result.append(temp);
                count++;
               
            }
        }
        return result.reverse().toString().toUpperCase();
    }
}