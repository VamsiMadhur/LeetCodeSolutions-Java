class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.isEmpty()) {
            return 0;
        }
        int len = haystack.indexOf(needle);
        return len;
    }
}