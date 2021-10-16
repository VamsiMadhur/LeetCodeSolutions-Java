class Solution {
    public boolean validWordSquare(List<String> words) {
        int k = words.size();
        int n = 0;
        for(String word:words) {
            n = Math.max(n, word.length());
        }
        if(n!=k) return false;
        
        int i=0;
        for(i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                String a = words.get(i);
                String b = words.get(j);
                
                if(a.length() <= j && b.length() <= i) {
                    continue;
                } else if(a.length() <= j || b.length() <= i) {
                    return false;
                } else if(a.charAt(j) != b.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}