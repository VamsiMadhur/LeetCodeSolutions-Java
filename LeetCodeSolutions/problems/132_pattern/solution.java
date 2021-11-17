class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if(n < 3) return false;
        
        int[] min = new int[n];
        min[0] = nums[0];
        for(int i=1; i<n; i++) {
            min[i] = Math.min(min[i-1], nums[i]);
        }
        
        for(int j=n-2, k=n-1; j>=0; j--) {
            if(nums[j] > min[j]) {
                while(k<n && nums[k] <= min[j]) k++;
                if(k < nums.length && nums[k] < nums[j]) return true;
                nums[--k] = nums[j];
            }
        }
        return false;
    }
}