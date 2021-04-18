class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        
        int tempStart = 0;
        int tempEnd = 0;
        
        for(int i=0; i<nums.length; i++) {
            if(i==nums.length-1||nums[i]+1 != nums[i+1]) {
                tempEnd = i;
                StringBuilder temp = new StringBuilder();
                if(tempStart == tempEnd) {
                    temp.append(nums[tempEnd]);
                } else {
                    temp.append(nums[tempStart]).append("->").append(nums[tempEnd]);
                }
                result.add(temp.toString());
                tempStart = i+1;
            }
        }
        return result;
    }
}