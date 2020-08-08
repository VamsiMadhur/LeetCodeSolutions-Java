class Solution {
   public  boolean isPalindrome(int x) {
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}
		int i = 0;
		while (x > i) {
			i = i * 10 + x % 10;
			x /= 10;
		}
		return x == i || x == i / 10;
	}
}