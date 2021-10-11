class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        char[] sa = s.toCharArray();
        int count = 0;
        
        for(int i=0; i<sa.length; i++) {
            if(sa[i] == '(' || sa[i] == '{' || sa[i] == '[') {
                stack[count++] = sa[i];
            } else {
                if(count == 0) return false;
                
                char temp = stack[--count];
                if((sa[i] == ')' && temp == '(')
                        || (sa[i] == '}' && temp == '{')
                        || (sa[i] == ']' && temp == '[')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return count==0;
    }
}