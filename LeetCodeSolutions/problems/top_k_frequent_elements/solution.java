class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == k) return nums;
        
        int n = nums.length, min = nums[0], max = nums[0];
        for(int i=1; i<n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        int[] counts = new int[max-min+1];
        for(int num : nums) {
            counts[num-min]++;
        }
        
        List<Integer>[] arrayByCount = new List[n+1];
        
        for(int i=0; i<counts.length; i++) {
            if(counts[i] == 0) continue;
            
            int num = i+min;
            if(arrayByCount[counts[i]] == null) 
                arrayByCount[counts[i]] = new ArrayList<>();
            
            arrayByCount[counts[i]].add(num);
        }
        
        int index=k-1;
        int[] result = new int[k];
        for(int i=arrayByCount.length-1; i>=0; i--) {
            if(arrayByCount[i] == null) continue;
            for(int num : arrayByCount[i]) {
                result[index--] = num;
                if(index == -1) return result;
            }
        }
        return result;
    }
}