class Solution {
    public int lengthOfLongestSubstring(String s) {
       int result = 0;
		Map<Character, Integer> charPosMap = new HashMap<Character, Integer>();
		int initialIndex = 0;
		for (int i = 0; i < s.length(); i++) {
			if(charPosMap.containsKey(s.charAt(i))) {
				initialIndex = Math.max(initialIndex, charPosMap.get(s.charAt(i))+1);
			}
			result = Math.max(result, i-initialIndex + 1);
			charPosMap.put(s.charAt(i),i);
		}
		return result;
    }
}