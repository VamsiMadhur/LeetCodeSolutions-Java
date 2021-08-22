class Solution {
    
    private static Map<Character, Integer> mapper = new HashMap<>();
    
    static {
        mapper.put('I', 1);
        mapper.put('V', 5);
        mapper.put('X', 10);
        mapper.put('L', 50);
        mapper.put('C', 100);
        mapper.put('D', 500);
        mapper.put('M', 1000);
    }
    
    public int romanToInt(String s) {
        int answer = 0;
        int prev = 0;
        for(int i=0; i<s.length(); i++) {
            int currValue = mapper.get(s.charAt(i));
            int nextValue = 0;
            if(i+1 < s.length()) {
                nextValue = mapper.get(s.charAt(i+1));
            }
            if(nextValue > currValue) {
                answer += (nextValue - currValue);
                i++;
            } else {
                answer += currValue;
            }
        }
        return answer;
        
    }
}