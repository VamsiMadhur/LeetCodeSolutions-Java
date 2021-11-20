class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        int n = nums.length;
        for(int i=0; i<n; i++) {
            count[nums[i]]++;
        }
        
        int w=0;
        for(int i=0; i<n; i++) {
            while(count[w] <= 0) w++;
            if(count[w]>0) {
                count[w]--;
                nums[i] = w;
            } 
        }
    }
        
   
}