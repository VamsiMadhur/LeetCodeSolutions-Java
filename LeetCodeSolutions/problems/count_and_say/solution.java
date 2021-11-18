class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        
        String prev = countAndSay(n-1);
        StringBuilder result = new StringBuilder();
        
        int m = prev.length();
        char c = prev.charAt(0);
        int i=1, count = 1;
        while(i<m) {
            if(prev.charAt(i) == c) count++;
            else {
                result.append(count).append(c);
                c = prev.charAt(i);
                count = 1;
            }
            i++;
        }
        result.append(count).append(c);
        return result.toString();
        
    }
}