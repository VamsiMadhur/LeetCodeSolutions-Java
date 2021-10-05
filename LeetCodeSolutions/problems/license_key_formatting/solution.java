class Solution {
    public String licenseKeyFormatting(String s, int k) {
        int i=0;
        StringBuilder result = new StringBuilder();
        char[] sa = s.toCharArray();
        for(int j = sa.length-1; j>=0; j--) {
            char c = sa[j];
            if('-' == c) continue;
            else {
                 if(i == k) {
                    result.append('-');
                    i=0;
                }
                result.append(c);
                i++;
            }
        }
        return result.reverse().toString().toUpperCase();
    }
}