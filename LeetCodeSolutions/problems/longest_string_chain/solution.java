class Solution {
    public int longestStrChain(String[] words) {
        if(words == null || words.length == 0) return 0;
        
        int result = 0;
        Arrays.sort(words, (a,b) -> (a.length() - b.length()));
        
        Map<String, Integer> cache = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for(String word : words) {
            int wordRank = 1;
            for(int i=0; i<word.length(); i++) {
                sb.setLength(0);
                sb.append(word);
                String next = sb.deleteCharAt(i).toString();
                
                if(cache.getOrDefault(next, 0) + 1 > wordRank) {
                    wordRank = cache.get(next)+1;
                }
                cache.put(word, wordRank);
                result = Math.max(result, wordRank);
            }
        }
        return result;
    }
}