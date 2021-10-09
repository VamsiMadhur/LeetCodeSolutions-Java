class Solution {
    public int firstUniqChar(String s) {
         int pos = Integer.MAX_VALUE;
        for(char c ='a';c<='z';c++){
            int k = s.indexOf(c);
            if (k>= 0 && k == s.lastIndexOf(c))
            {
                pos = Math.min(pos,k);
            }
        }
        if (pos == Integer.MAX_VALUE){
            return -1;
        }
        return pos;

    }
}