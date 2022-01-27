class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = nums[0];
        for(int n : nums) max = Math.max(max, n);
        int temp = max;
        int length = 0;
        while(max!=0) {
            max >>=1; length++;
        }
        
        int maxXor = 0;
        int currXor = 0;
        Set<Integer> p1 = new HashSet<>();
        for(int i=length-1; i>=0; i--) {
            maxXor <<= 1;
            currXor = maxXor | 1;
            
            p1.clear();
            for(Integer n : nums) p1.add(n >>= i);
            for(int n : p1) {
                if(p1.contains(currXor ^ n)) {
                    maxXor = currXor;
                    break;
                }
            }
        }
        return maxXor;
    }
}