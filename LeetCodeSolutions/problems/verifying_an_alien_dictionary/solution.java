class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        char[] alphabets = order.toCharArray();
        int[] rank = new int[26];
        for(int i=0; i<alphabets.length; i++) {
            rank[alphabets[i] - 'a'] = i;
        }
        
        
        for(int i=0; i<words.length-1; i++) {
            boolean flag = false;
            char[] a = words[i].toCharArray();
            char[] b = words[i+1].toCharArray();
            
            for(int j=0; j<a.length && j<b.length; j++) {
                if(rank[a[j] - 'a'] > rank[b[j] - 'a']) {
                    return false;
                } else if(rank[a[j] - 'a'] == rank[b[j] - 'a']) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if(flag && a.length > b.length) {
                return false;
            }
        }
        
        return true;
    }
}