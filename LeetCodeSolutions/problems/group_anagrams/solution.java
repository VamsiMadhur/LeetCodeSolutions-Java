class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        
        for(int i=0; i<strs.length; i++) {
            String temp = new String(strs[i]);
            char[] arr = temp.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            result.computeIfAbsent(key, k -> new ArrayList<>()).add(temp);
        }
        return new ArrayList<>(result.values());
    }
}