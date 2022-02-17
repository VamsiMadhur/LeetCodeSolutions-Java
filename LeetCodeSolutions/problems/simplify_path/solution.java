class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        
        String[] levels = path.split("/");
        
        StringBuilder result = new StringBuilder();
        for(String level : levels) {
            if(level.isEmpty()) continue;
            else if(".".equals(level)) continue;
            
            else if("..".equals(level)) {
                if(!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(level);
            }
        }
        
        for(String s : stack) {
            result.append("/").append(s);
        }
        return result.length() == 0 ? "/" : result.toString();
    }
}