class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int n = nums.length;
        
        int candidate1 = nums[0];
        int count1 = 1;
        int candidate2 = 0;
        int count2 = 0;
        
        int i=1;
        for(; i<n; i++) {
            if(candidate1 != nums[i]) {
                candidate2 = nums[i];
                count2++;
                break;
            } else {
                count1++;
            }
        }
        
        i++;
        for( ;i<n; i++) {
            if(candidate1 == nums[i]) {
                count1++;
            } else if(candidate2 == nums[i]) {
                count2++;
            } else if(count1 == 0) {
                candidate1 = nums[i];
                count1++;
            } else if(count2 == 0) {
                candidate2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        for(int num : nums) {
            if(num == candidate1) {
                count1++;
            } else if(num == candidate2) {
                count2++;
            }
        }
        
        List<Integer> result = new ArrayList<Integer>(2);
        
        if(count1 > n/3) {
            result.add(candidate1);
        }
        if(count2 > n/3) {
            result.add(candidate2);
        }
        return result;
    }
}