class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int low = 0, high = nums.length-1;

        if(nums[low] < nums[high]) return nums[low];
        
        while(low<=high) {
            int mid = low + (high-low)/2;
            
           if(nums[mid] > nums[mid+1]) return nums[mid+1];
            if(nums[mid] < nums[mid-1]) return nums[mid];
            
            if(nums[mid] > nums[low]) {
                low = mid+1;
            } else {
                high = mid-1;                
            }
        }
        return nums[0];
    }
}