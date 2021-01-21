class Solution {
    public int lengthOfLastWord(String s) {
       int length = 0;

		char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) { 
			if (chars[i] != ' ') {
				length++;
			} else {
				if (length > 0) { 
					return length;
				}
			}
		}

		return length;
    }
}