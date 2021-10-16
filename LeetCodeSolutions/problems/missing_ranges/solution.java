class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        List<String> result = new ArrayList<>();
        int prev = lower-1;
        int curr=0;
        
        for(int i=0; i<n; i++) {
            curr = nums[i];
            if(curr != prev+1) {
                StringBuilder temp = new StringBuilder();
                if(prev+1 == curr-1) {
                    temp.append(prev+1);
                } else {
                    temp.append(prev+1).append("->").append(curr-1);
                }
                result.add(temp.toString());
            }
            prev = curr;
        }
        
        curr = upper+1;
        if(curr != prev+1) {
            StringBuilder temp = new StringBuilder();
            if(prev+1 == curr-1) {
                temp.append(prev+1);
            } else {
                temp.append(prev+1).append("->").append(curr-1);
            }
            result.add(temp.toString());
        }
        prev = curr;
        
        return result;
    }
}