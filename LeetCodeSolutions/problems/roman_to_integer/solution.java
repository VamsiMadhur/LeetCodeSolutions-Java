class Solution {
    public int romanToInt(String s) {
        
        Map<Character, Integer> converter = new HashMap<Character, Integer>(7);
        converter.put('I',1);
        converter.put('V',5);
        converter.put('X',10);
        converter.put('L',50);
        converter.put('C',100);
        converter.put('D',500);
        converter.put('M',1000);
        
        int totalValue = 0;
        int previousValue = 0;
        for(int i=0; i<s.length(); i++) {
            int currentValue = converter.get(s.charAt(i));
            if(previousValue == 0 || previousValue >= currentValue) {
                totalValue += currentValue;
            } else {
                totalValue = totalValue - (2*previousValue) + currentValue;
            }                       
            previousValue = currentValue;
        }
        
        return totalValue;
    }
}