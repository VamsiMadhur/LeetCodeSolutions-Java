class Solution {
    
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[n]; 
        int result = 0;
        for(int i=0; i<n; i++) {
            if(!seen[nums[i]]) {
                int num = nums[i];
                int curr = 0;
                while(!seen[num]) {
                    seen[num] = true;
                    curr++;
                    num = nums[num];
                }
                result = Math.max(result, curr);
            }
        } 
        
        return result;
    }
}