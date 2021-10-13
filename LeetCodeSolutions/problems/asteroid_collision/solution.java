class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int id = -1;
        int n = asteroids.length;
        int[] result = new int[n];
        result[0] = asteroids[0];
        int count = 0;
        
        for(int i=1; i<n; i++) {
            if(asteroids[i] < 0) {
                boolean flag = true;
                
                while(count >= 0) {
                    if(result[count] > 0) {
                        if((-1*asteroids[i]) > result[count]) {
                            count--;
                        } else if((-1*asteroids[i]) == result[count]) {
                            count--;
                            flag = false;
                            break;
                        } else {
                            flag = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                
                if(flag)
                    result[++count] = asteroids[i];
            } else {
                result[++count] = asteroids[i];
            }
        }
        
        int[] ra = new int[count+1];
        for(int i=0; i<=count; i++) {
            ra[i] = result[i];
        }
        return ra;
    }
}