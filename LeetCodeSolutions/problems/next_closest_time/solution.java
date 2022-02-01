class Solution {
    public String nextClosestTime(String time) {
        int h1 = time.charAt(0) - '0';
        int h2 = time.charAt(1) - '0';
        
        int m1 = time.charAt(3) - '0';
        int m2 = time.charAt(4) - '0';
        
        int ctime = (((h1*10) + h2)*60) + (m1*10) + m2;
        Set<Integer> digits = new HashSet<>();
        digits.add(h1);
        digits.add(h2);
        digits.add(m1);
        digits.add(m2);
        
        while(true) {
            ctime = (ctime+1) % (24*60);
            int hours = ctime/60;
            int minutes = ctime%60;
            
            int dh1 = hours/10; int dh2 = hours%10;
            int dm1 = minutes/10; int dm2 = minutes%10;
            
            int[] timeArray = new int[]{dh1, dh2, dm1, dm2};
            
            boolean isValid = true;
            
            for(int t : timeArray) {
                if(!digits.contains(t)) {
                    isValid = false;
                    break;
                }
            }
            
            if(isValid) {
                StringBuilder result = new StringBuilder();
                result.append(hours <= 9? "0" + hours : hours).append(":").append(minutes <= 9? "0" + minutes : minutes);
                return result.toString();
            }
        }
        
    }
}