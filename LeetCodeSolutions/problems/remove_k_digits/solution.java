class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(n == k) return "0";
        
        LinkedList<Character> stack = new LinkedList<>();
        for(char c : num.toCharArray()) {
            while(stack.size() > 0 && k>0 && stack.peekLast() > c) {
                stack.removeLast();
                k -= 1;
            }
            stack.addLast(c);
        }
        
        for(int i=0; i<k; i++) {
            stack.removeLast();
        }
        
        StringBuilder res = new StringBuilder();
        boolean flag = true; 
        for(char c : stack) {
            if(flag && c == '0') continue;
            flag = false;
            res.append(c);
        }
        if(res.length() == 0) return "0";
        return res.toString();
        
    }
}