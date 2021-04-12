class Solution {
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        int n = a.length;
        for (int start = 0; start < n; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, n - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }
}