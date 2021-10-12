class Solution {
    public String getHint(String secret, String guess) {
        int cows = 0, bulls = 0;
        int n = secret.length();
        
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        
       int[] cache = new int[10];
        for(char c : s) {
            cache[c - '0'] ++;
        }
        
        for(int i=0; i<n; i++) {
            char c = g[i];
            int key = c - '0';
            if(s[i] == c) {
                bulls++;
                if(cache[key]> 0)
                    cache[key]--;
                else
                    cows--;
            } else if(cache[key] > 0) {
                cows++;
                cache[key]--;
            }
        }
        StringBuilder result = new StringBuilder();
        result.append(bulls).append("A").append(cows).append("B");
        return result.toString();
    }
}