class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length==0) {
            return false;
        }
        Set<Integer> duplicateSet = new HashSet<Integer>(k+1);
        for(int i=0; i<nums.length; i++) {
            if(i>k)
                duplicateSet.remove(nums[i-k-1]);
            if(!duplicateSet.add(nums[i]))
                return true;
        }
        return false;
    }
}