class Solution {
    public int removeDuplicates(int[] nums) {
        int currentIndex = 0;
        int prev=0;
        for(int i=0; i<nums.length; i++) {
            if(i==0) {
                prev = nums[i];
                currentIndex = i;
                continue;
            }
            if(prev != nums[i]) {
                currentIndex++;
                nums[currentIndex] = nums[i];
                prev = nums[i];
            }          
            
        }
        return currentIndex+1;
    }
}