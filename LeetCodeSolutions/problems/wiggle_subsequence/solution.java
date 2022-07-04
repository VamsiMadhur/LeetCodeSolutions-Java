public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n==1) return 1;
        
        int prev = nums[0], resultP = 1, resultN = 1;
        boolean flagP = true, flagN = false;
        
        for(int i=1; i<n; i++) {
            if(nums[i] == prev) continue;
            
            if((flagP && nums[i] > prev) || (!flagP && nums[i] < prev)) {
                resultP++;
                flagP = !flagP;
            } 
            
            if((flagN && nums[i] > prev) || (!flagN && nums[i] < prev)) {
                resultN++;
                flagN = !flagN;
            }
            prev = nums[i];
        }
        
        return Math.max(resultP, resultN);
    }
}