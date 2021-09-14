class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for(int a : nums) {
            count[a]++;
        }
        
        int a = 0;
        int b = 0;
        int prevKey = -1;
        for(int key=0; key<10001;key++) {
            if(count[key]>0) {
                if(prevKey+1 == key) {
                    int temp = a + (key*count[key]);
                    temp = Math.max(temp, b);
                    a = b;
                    b = temp;
                } else {
                    int temp = b + (key*count[key]);
                    a = b;
                    b = temp;
                }
                prevKey = key;
            }
            
        }
        return Math.max(a,b);
    }
}