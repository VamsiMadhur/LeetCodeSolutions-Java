class Solution {
    public int numSplits(String s) {
        int[] sn = new int[26];
        char[] sa = s.toCharArray();
        int count = 0;
        for(char c : sa)
            if(sn[c-'a']++ == 0)
                count++;
        int result = 0;
        boolean[] left = new boolean[26];
        int leftC = 0;
        for(char c : sa) {
            if(!left[c-'a']) leftC++;
            left[c-'a'] = true;
            if(--sn[c-'a'] == 0) count--;
            if(leftC == count) result++;
        }
        return result;
    }
}