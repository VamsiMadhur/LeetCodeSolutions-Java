class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0, n=nums.length;
        for(int num : nums) sum += num;
         int maxLength=-1, currSum=0, target=sum-x;
        if(sum == x) return n;
        if(target < 0) return -1;
        for(int l=0, r=0; r<n; r++) {
            currSum += nums[r];
            while(l<=r && currSum > target) currSum -= nums[l++];
            if(currSum == sum-x) maxLength = Math.max(maxLength, r-l+1);
            
        }
        
        return maxLength == -1 ? -1: n-maxLength;
    }
}