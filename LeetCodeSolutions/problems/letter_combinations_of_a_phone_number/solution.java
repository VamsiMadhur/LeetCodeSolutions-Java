class Solution {
    private static Map<String, String[]> converter = new HashMap<String, String[]>();
    static {
        converter.put("2", new String[] {"a","b","c"});
        converter.put("3", new String[] {"d","e","f"});
        converter.put("4", new String[] {"g","h","i"});
        converter.put("5", new String[] {"j","k","l"});
        converter.put("6", new String[] {"m","n","o"});
        converter.put("7", new String[] {"p","q","r", "s"});
        converter.put("8", new String[] {"t","u","v"});
        converter.put("9", new String[] {"w","x","y", "z"});
    }
    public List<String> letterCombinations(String digits) {
        
        List<String> r2 = new ArrayList<String>();
        for(int i=0; i<digits.length(); i++) {
            String curr = "";
            curr += digits.charAt(i);
            String[] curDig = converter.get(curr);
        
            List<String> r1 = new ArrayList<String>();            
            if(r2.isEmpty()) {
                r2.addAll(Arrays.asList(curDig));
            } else {
                for(String k : r2) {
                    for(String cur : curDig) {
                        r1.add(k+cur);
                    }
                }
                r2.clear();
                r2.addAll(r1);
            }
        }
        return r2;
    }
}