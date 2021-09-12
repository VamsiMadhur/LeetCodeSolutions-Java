class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int rounds = 0;
        int val = 0;
        while(val <= candies) {
            rounds++;
            val = calculate(rounds*num_people);
        }
        if(val>candies) rounds--;
        
        int value = calculate(rounds-1)*num_people;
        int[] result = new int[num_people];
        if(rounds>0) {
            for(int i=1; i<=num_people; i++){
                int temp = (rounds*i) + value;
                result[i-1] = temp;
                candies -= temp;
            }
        }
        
        int curr = (rounds * num_people) + 1;
        int index = 0;
        while(curr < candies) {
            result[index++] += curr;
            candies -= curr;
            curr++;
        }
        result[index] += candies;
        return result;
        
    }
    
    private int calculate(int n) {
        return (n*(n+1))/2;
    }
}