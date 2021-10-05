class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;
        while(i<j) {
            int x = numbers[i] + numbers[j];
            if(x == target) {
                return new int[]{i+1,j+1};
            } else if(x > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[2];
    }
}