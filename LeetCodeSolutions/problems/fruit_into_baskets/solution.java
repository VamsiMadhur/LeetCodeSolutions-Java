class Solution {
    public int totalFruit(int[] fruits) {

        int result = 0, curr = 0, a = 0, b = 0, countB = 0;
        
        for(int c : fruits) {
            if(c == b) {
                countB ++;
                curr++;
            } else if(c == a) {
                a = b;
                b = c;
                countB = 1;
                curr++;
            } else {
                a = b;
                b = c;
                curr = countB + 1;
                countB = 1;
            }
            result = Math.max(result, curr);
        }
        return result;
    }
}