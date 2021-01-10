class Solution {
        static Integer[] ava = new Integer[] {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        
        static Map<Integer, String> converter = new HashMap<Integer, String>(13);
    static {
        converter.put(1, "I");
        converter.put(4, "IV");
        converter.put(5, "V");
        converter.put(9, "IX");
        converter.put(10, "X");
        converter.put(40, "XL");
        converter.put(50, "L");
        converter.put(90, "XC");
        converter.put(100, "C");
        converter.put(400, "CD");
        converter.put(500, "D");
        converter.put(900, "CM");
        converter.put(1000, "M");
    }
    public String intToRoman(int num) {
        
        int i = ava.length - 1;
        String result = "";
        
        while(num != 0) {
            if(num >= ava[i]) {
                result += converter.get(ava[i]);
                num = num - ava[i];
            } else {
                i--;
            }    
        }
        return result;
    }
}