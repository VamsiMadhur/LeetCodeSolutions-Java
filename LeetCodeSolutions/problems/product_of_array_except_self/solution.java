class Solution {
    public int[] productExceptSelf(int[] nums) {
        boolean isZeroPresent = false;
        boolean areZerosPresent = false;
        int product = 1;
        for(int i : nums) {
            if(i!=0) {
                product *= i;
            } else if(isZeroPresent) {
                areZerosPresent = true;
            } else {
                isZeroPresent = true;
            }
        }
        
        int[] result = new int[nums.length];
        if(areZerosPresent) {
            //nothing
        } else if(isZeroPresent) {
            for(int i=0; i<nums.length; i++) {
                if(nums[i]==0) {
                    result[i] = product;
                }
            }
        } else {
            for(int i=0; i<nums.length; i++) {
                result[i] = product/nums[i];
            }
        }
        
        return result;
    }
}