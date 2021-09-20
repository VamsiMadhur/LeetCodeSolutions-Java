class Solution {
    public int getMaxLen(int[] nums) {
        
        int first = -1, last = -1, lastZero = -1, count = 0;
        int result = 0;
        int n = nums.length;
        int i=0;
        for(i=0; i<nums.length; i++) {
            if(nums[i]==0) {
                if(count%2 == 0 || first == -1) {
                    result = Math.max(i-lastZero - 1, result);
                } else {
                     int a = Math.max(first-lastZero-1, i-first -1);
                     int b = Math.max(last-lastZero-1, i-last-1);
                     result = Math.max(result, Math.max(a,b));
                }
                count = 0;
                first = -1;
                last = -1;
                lastZero = i;
            } else if(nums[i]<0) {
                count++;
                if(first == -1) {
                    first = i;
                } 
                last = i;
            }
        }
        
        if(count%2 == 0 || first == -1) {
            result = Math.max(i-lastZero - 1, result);
        } else {
            int a = Math.max(first-lastZero-1, i-first -1);
            int b = Math.max(last-lastZero-1, i-last-1);
            result = Math.max(result, Math.max(a,b));
        }
        return result;
    }
}