class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length-1;
        int p1 = 0;
        int p2 = n;
        int curr = 0;
        while(curr<=n && nums[curr]==0) {
            curr++;
            p1++;
        }
        
        while(curr <= p2) {
            if(nums[curr]==0) {
                int temp = nums[p1];
                nums[p1] = 0;
                nums[curr] = temp;
                p1++;
                curr++;
            } else if(nums[curr]==2) {
                int temp = nums[p2];
                nums[p2] = 2;
                nums[curr] = temp;
                p2--;
            } else {
                curr++;
            }
            
        }
    }
}