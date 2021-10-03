class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> cache = new HashSet<>();
        for(int num : nums) {
            if(!cache.add(num)) return true;
        }
        return false;
    }
}