class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> cache = new HashSet<>();
        for(String email : emails) {
            StringBuilder result = new StringBuilder();
            int i=0;
            for(; i<email.length(); i++) {
                char c = email.charAt(i);
                if('.' == c) {
                    continue;
                } else if('@' == c) {
                    break;  
                } else if('+' == c) {
                    i = email.indexOf("@");
                    break;
                } else {
                    result.append(c);
                }
            }
            result.append(email.substring(i));
            cache.add(result.toString());
        }
        return cache.size();
    }
}