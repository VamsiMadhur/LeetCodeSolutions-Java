class TwoSum {

    Map<Integer, Integer> mapper;

    /** Initialize your data structure here. */
    public TwoSum() {
        mapper = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        mapper.put(number, (mapper.getOrDefault(number, 0) + 1));
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Map.Entry<Integer, Integer> entry : mapper.entrySet()) {
            int required = value - entry.getKey();
            if((required != entry.getKey() && mapper.containsKey(required)) || (required == entry.getKey() && entry.getValue() > 1)) 
                return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */