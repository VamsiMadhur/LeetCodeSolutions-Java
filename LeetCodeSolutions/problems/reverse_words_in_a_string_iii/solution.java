class Solution {
    public String reverseWords(String s) {
        String[] sarr = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(String sa : sarr) {
            result.append(new StringBuffer(sa).reverse()).append(" ");
        }
        return result.toString().trim();
    }
}