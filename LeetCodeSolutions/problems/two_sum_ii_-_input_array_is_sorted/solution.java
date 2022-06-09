class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int n=numbers.length;
        int i=0, j=n-1, sum=0, mid=0;
        while(i<j) {
            sum = numbers[i] + numbers[j];
            mid = i + (j-i)/2;
            if(sum < target) {
                if(numbers[mid] + numbers[j] < target) i = mid+1;
                else i++;
                
            } else if(sum > target){
                if(numbers[i] + numbers[mid] > target) j = mid-1;
                else j--;  
            } 
            else {
                result[0] = i+1;
                result[1] = j+1;
                break;
            }
        }
        return result;
    }
}