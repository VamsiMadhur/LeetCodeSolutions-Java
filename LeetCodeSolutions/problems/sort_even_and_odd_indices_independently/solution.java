class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;
        int ne = (n+1)>>1, no = n>>1;
        int[] even = new int[ne];
        int[] odd = new int[no];
        for(int i=0, index=0; i<n; i+=2, index++) {
            even[index] = nums[i];
        }
        for(int i=1, index=0; i<n; i+=2, index++) {
            odd[index] = nums[i];
        }


        Arrays.sort(even);
        Arrays.sort(odd);
        for(int i=0, index=0; i<ne; index+=2) {
            nums[index] = even[i++];
        }
        for(int i=no-1, index=1; i>=0; index+=2) {
            nums[index] = odd[i--];
        }
        return nums;
    }
}