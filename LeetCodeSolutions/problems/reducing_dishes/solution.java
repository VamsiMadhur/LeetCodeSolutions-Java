class Solution {
    public int maxSatisfaction(int[] satisfaction) {
       int n = satisfaction.length;
        Arrays.sort(satisfaction);
        
        int result=0, sum=0, temp=0;
        for(int i=n-1; i>=0; i--) {
            temp = result + sum + satisfaction[i];
            if(temp < result) break;
            
            result = temp;
            sum += satisfaction[i];
        }
        return result;
    }
}