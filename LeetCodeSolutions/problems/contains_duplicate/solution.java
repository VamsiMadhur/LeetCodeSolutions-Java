class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashhset = new HashSet<Integer>(nums.length);
        for(int num : nums) {
            if(!hashhset.add(num)) {
                return true;
            } 
        }
        return false;
    }
}