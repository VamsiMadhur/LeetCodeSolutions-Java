class Solution {
    public int findComplement(int num) {
        int result = 0;
        int digitValue = 0;
        while(num != 0) {
            int cur = ((num & 1)^1);
            cur <<= digitValue++;
            result |= cur;
            num >>= 1;
        }
        return result;
    }
}