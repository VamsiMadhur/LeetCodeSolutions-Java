class Solution {
    public boolean isLongPressedName(String name, String typed) {
        char[] na = name.toCharArray();
        char[] typeda = typed.toCharArray();
        
        if(na.length > typeda.length) return false;
        if(na[0] != typeda[0]) return false;
        
        int index = 1;
        int i=1;
        for(i=1; i<na.length; i++) {
            if(index == typeda.length) return false;
            if(na[i] == typeda[index]) {
                index++;
                continue;
            } else {
                while(na[i-1] == typeda[index]) {
                    index++;
                    if(index == typeda.length ) return false;
                }
                if(na[i] != typeda[index]) return false;
                index++;
            }
        }
        while(index < typeda.length && na[i-1] == typeda[index]) index++;
        
        return index == typeda.length;
    }
}