class Solution {
    public char findTheDifference(String s, String t) {
        char cr=0;
        for(char c: t.toCharArray()) cr ^= c;
        for(char c: s.toCharArray())  cr ^= c;
        return cr;
    }
}