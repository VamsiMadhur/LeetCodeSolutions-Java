class Solution {

    private static final Map<Character, Integer> map = new HashMap<>();
    static {
        map.put('q',1);
        map.put('w',1);
        map.put('e',1);
        map.put('r',1);
        map.put('t',1);
        map.put('y',1);
        map.put('u',1);
        map.put('i',1);
        map.put('o',1);
        map.put('p',1);
        
        map.put('a',2);
        map.put('s',2);
        map.put('d',2);
        map.put('f',2);
        map.put('g',2);
        map.put('h',2);
        map.put('j',2);
        map.put('k',2);
        map.put('l',2);
        
        map.put('z',3);
        map.put('x',3);
        map.put('c',3);
        map.put('v',3);
        map.put('b',3);
        map.put('n',3);
        map.put('m',3);
    }
    
    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        for(String w: words){
            if(w.equals("")) {
                continue;
            }
            String curr = w.toLowerCase();
            int index = map.get(curr.charAt(0));
            for(int i=0; i<w.length(); i++){
                char c = curr.charAt(i);
                if(map.get(c)!=index){
                    index = -1;
                    break;
                }
            }
            if(index!=-1) {
                res.add(w);
            }
        }
        return res.toArray(new String[0]);
    }
}