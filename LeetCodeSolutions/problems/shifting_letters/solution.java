class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int totalShift = 0;
        char[] result = s.toCharArray();
        
        for(int i=shifts.length-1; i>=0; i--) {
            totalShift = (totalShift + shifts[i])%26;
            result[i] += totalShift;
            while(result[i] > 'z')
                result[i] -= 26;
        }
        return new String(result);
    }
}