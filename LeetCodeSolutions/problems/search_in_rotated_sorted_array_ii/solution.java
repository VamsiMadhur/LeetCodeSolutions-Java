class Solution {
    public boolean existsInFirst(int[] nums, int start, int target) {
        return nums[start] <= target;
    }
    
    public boolean isBinarySearchAllowed(int[] nums, int start, int target) {
        return nums[start] != target;
    }
    
    public boolean search(int[] nums, int target) {
        int l=0;
        int r = nums.length-1;
        
        while(l<=r) {
            int mid = (l+r)/2;
            if(nums[mid] == target || nums[l] == target || nums[r] == target) {
                return true;
            }
            
            if(!isBinarySearchAllowed(nums, l, nums[mid])) {
                l++;
            } else {
                boolean isMidInFirstArray = existsInFirst(nums, l, nums[mid]);
                boolean isTargetInFirstArray = existsInFirst(nums, l, target);
                
                if(isMidInFirstArray ^ isTargetInFirstArray) {
                    if(isTargetInFirstArray) {
                        r = mid-1;
                    } else {
                        l = mid+1;
                    }
                } else {
                     if(nums[mid] > target) {
                        r = mid-1;
                    } else {
                        l = mid+1;
                    }
                }
            }
        }
        return false;
    }
}