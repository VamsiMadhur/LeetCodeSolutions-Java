class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        
        int n = releaseTimes.length;
        int largest = releaseTimes[0];
        char result = keysPressed.charAt(0);
        for(int i=1; i<n; i++) {
            int curr = releaseTimes[i] - releaseTimes[i-1];
            char key = keysPressed.charAt(i);
            if(curr == largest && key > result) {
                result = key;
            } else if(curr > largest) {
                largest = curr;
                result = key;
            }
        }
        return result;
    }
}