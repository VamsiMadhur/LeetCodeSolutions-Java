class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = binarySearch(nums, target, 0, nums.length-1, true);
        int rightIndex = -1;
        if(leftIndex != -1) {
            rightIndex = binarySearch(nums, target, leftIndex, nums.length-1, false);    
        } 
        
        int[] result = new int[]{leftIndex, rightIndex};
        return result;
    }
    
    public int binarySearch(int[] nums, int target, int low, int high, boolean leftSearch) {
        int mid = (low+high)/2;
       
        while(low <= high) {
            if(nums[mid]==target) {
                if(leftSearch) {
                    if(mid==0 || nums[mid-1] < target) {
                        return mid;
                    } 
                    return binarySearch(nums, target, low, mid-1, leftSearch);    
                } else {
                    if(mid == nums.length-1 || nums[mid+1] > target) {
                        return mid;
                    }
                    return  binarySearch(nums, target, mid+1, high, leftSearch);
                }
            }
            else if(nums[mid]>target) {
                return binarySearch(nums, target, low, mid-1, leftSearch);
            } else {
                return binarySearch(nums, target, mid+1, high, leftSearch);
            }
        }
        return -1;
    }
}