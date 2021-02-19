class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sa = s.split(" ");
        if(sa.length != pattern.length()) {
            return false;
        }
        Map mapper = new HashMap<>();
        for(Integer i=0; i<pattern.length(); i++) {
            if(mapper.put(pattern.charAt(i), i) != mapper.put(sa[i],i)) {
                return false;
            }   
        }
        return true;
    }
}