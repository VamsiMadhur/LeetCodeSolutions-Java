class Solution {
    public boolean isStrobogrammatic(String num) {
        
        char[] cache = new char[10];
        Arrays.fill(cache, '*');
        cache[0] = '0';
        cache[1] = '1';
        cache[6] = '9';
        cache[8] = '8';
        cache[9] = '6';
        
        char[] c = num.toCharArray();
        int i = 0;
        int j = c.length-1;
        while(i<=j) {
            if(c[i] != cache[c[j]-'0']) return false;
            i++;
            j--;
        }
        return true;
    }
}