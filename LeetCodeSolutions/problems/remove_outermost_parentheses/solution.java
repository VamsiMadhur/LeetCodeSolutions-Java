class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int temp=0;
        for(char c: s.toCharArray()) {
            if(c == '(') {
                if(temp!=0)
                    result.append(c);
                temp++;
            } else if(c == ')') {
                temp--;
                if(temp!=0)
                    result.append(c);
            }
        }
        return result.toString();
    }
}