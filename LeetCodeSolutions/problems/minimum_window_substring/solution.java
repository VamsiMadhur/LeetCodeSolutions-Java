class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0 || t.length() > s.length()) return "";
        
        Map<Character, Integer> dict = new HashMap<>();
        for(char c : t.toCharArray()) {
            dict.put(c, dict.getOrDefault(c,0) + 1);
        }
        
        int required = dict.size();
        
        List<Pair<Integer, Character>> filterS = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(dict.containsKey(c)) {
                filterS.add(new Pair<Integer, Character>(i, c));
            }
        }
        
        int l = 0; int r = 0; int formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<>();
        
        int[] ans = {-1, 0, 0};
        
        while(r < filterS.size()) {
            
            char c = filterS.get(r).getValue();
            windowCounts.put(c, windowCounts.getOrDefault(c, 0)+1);
            if(dict.containsKey(c) && windowCounts.get(c).intValue() == dict.get(c).intValue()) {
                formed++;
            }
            
            while(l<=r && formed==required) {
                c = filterS.get(l).getValue();
                
                int start = filterS.get(l).getKey();
                int end = filterS.get(r).getKey();
                if(ans[0]==-1 || end-start+1 < ans[0]) {
                    ans[0]=end-start+1;
                    ans[1]=start;
                    ans[2]=end;
                }
                
                windowCounts.put(c, windowCounts.get(c)-1);
                if(dict.containsKey(c) && windowCounts.get(c).intValue() < dict.get(c).intValue()) {
                    formed--;
                }
                
                l++;
            }
            
            r++;
        }
        
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1);
        
    }
}