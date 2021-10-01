class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        
        int numerator = rowIndex;
        int denominator = 1;
        int prev = 1;
        for(int i=0; i<rowIndex; i++) {
            prev = (int)(((long)prev*numerator)/denominator);
            numerator--;
            denominator++;
            result.add(prev);
        }
        return result;
    }
}