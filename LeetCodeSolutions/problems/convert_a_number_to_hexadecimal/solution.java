class Solution {
    public String toHex(int num) {
        if(num==0) {
            return "0";
        }
        StringBuffer result = new StringBuffer();
        while(num!=0) {
            int current = (num&15);
            if(current<10) {
                result.append(String.valueOf(current));
            } else {
                result.append((char)((current-10)+'a'));
            }
            num >>>= 4;
        }
        result.reverse();
        return result.toString();
    }
}