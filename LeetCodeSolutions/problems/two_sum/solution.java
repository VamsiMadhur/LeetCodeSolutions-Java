class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for(int i=0; i<nums.length; i++) {
            int x = target - nums[i];
            int y = cache.getOrDefault(x, -1);
            if(y != -1 && y != i) {
                result[0] = y;
                result[1] = i;
                return result;
            }
            cache.put(nums[i], i);
        }
        return result;
    }
}