class Solution {
    public boolean divideArray(int[] nums) {
        boolean[] cache = new boolean[501];
        for(int num:nums) 
            cache[num] = !cache[num];
        
        for(int num:nums) 
            if(cache[num]) return false;

        return true;
    }
}