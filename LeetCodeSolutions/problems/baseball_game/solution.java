class Solution {
    public int calPoints(String[] ops) {
        int totalScore = 0;
        int[] records = new int[ops.length];
        int index=0;
        
        for(String op : ops) {
            
            if("+".equals(op)) {
                records[index] = records[index-1] + records[index-2];
                totalScore += records[index++];
            } else if("C".equals(op)) {
                index--;
                totalScore -= records[index];
            } else if("D".equals(op)) {
                records[index] = 2*records[index-1] ;
                totalScore +=  records[index++];
            } else {
                records[index] = Integer.parseInt(op);
                totalScore +=  records[index++];                
            }
        }
        return totalScore;
    }
}