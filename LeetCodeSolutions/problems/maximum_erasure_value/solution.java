class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int[] sumCache = new int[nums.length+1];
        sumCache[0] = 0;
        for(int i=1; i<=nums.length; i++) {
            sumCache[i] = sumCache[i-1] + nums[i-1];
        }
        
        int[] cache = new int[10001];
        int result = 0, start=-1;
        for(int i=0; i<nums.length; i++) {
            if(cache[nums[i]] != 0) {
                start = Math.max(start, cache[nums[i]]-1);
            }
            result = Math.max(result, sumCache[i+1] - sumCache[start+1]);
            cache[nums[i]] =  i+1;
        }
        return result;
    }
}