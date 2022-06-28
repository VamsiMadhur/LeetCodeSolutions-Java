class Solution {
    public int minBitFlips(int start, int goal) {
        int result = 0;
        while(start!=0 || goal!=0) {
            result += ((start&1)^(goal&1));
            start>>=1;
            goal>>=1;
        }
        return result;
    }
}