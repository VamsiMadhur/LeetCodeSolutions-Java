class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] map = new char[127];
        char[] mapped = new char[127];
        
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();

        for (int i = 0; i < sa.length; i++) {
            if (map[sa[i]] == 0){
                if (mapped[ta[i]]!=0) return false;
                
                map[sa[i]] = ta[i];
                mapped[ta[i]] = sa[i];
            }

            if (map[sa[i]] != ta[i]) return false;
        }
        return true;
    }
}