class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        if(k!=0) {
            int count = 0;
            for(int i=0; count<n; i++) {
                int current = i;
                int temp = nums[i];
                do {
                    int next = (i+k)%n;
                    int x = nums[next];
                    nums[next] = temp;
                    temp = x;
                    i = next;
                    count++;
                } while(i!=current);
            }
        }
    }
}