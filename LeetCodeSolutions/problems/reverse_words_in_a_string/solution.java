class Solution {
    public String reverseWords(String s) {
        char[] sa = s.toCharArray();
        
        int left = 0, right = s.length()-1;
        
        while(left<=right && s.charAt(left) == ' ') ++left;
        while(left<=right && s.charAt(right) == ' ') --right;
        
        Deque<String> d = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        
        while(left<=right) {
            char c = sa[left];
            
            if((word.length() !=0) & (c == ' ')) {
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c!= ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());
        
        return String.join(" ", d);
        
    }
}