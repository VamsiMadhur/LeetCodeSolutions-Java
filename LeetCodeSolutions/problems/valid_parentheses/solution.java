
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> mapper = new HashMap<Character, Character>(3);
        mapper.put('(', ')');
        mapper.put('[', ']');
        mapper.put('{', '}');
        
        
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++) {
            Character curr = s.charAt(i);
            if(mapper.containsKey(curr)) {
                stack.push(curr);
            } else {
                if(stack.empty()) {
                    return false;
                }
                Character sr = stack.pop();
                if(mapper.get(sr) != curr) {
                     return false;    
                }
            }
        }
        return stack.empty();
    }
}