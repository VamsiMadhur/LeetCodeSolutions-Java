class Solution {
    public String countAndSay(int n) {
        if(n==1) {
            return "1";
        }
        String prevOne = countAndSay(n-1);
        Character prev = prevOne.charAt(0);
        int count=1;
        String result = "";
        int i=1;
        for(i=1; i<prevOne.length(); i++) {
              if(prev == prevOne.charAt(i)) {
                  count++;
              } else {
                  result+= String.valueOf(count) + prevOne.charAt(i-1);
                  count=1;
                  prev = prevOne.charAt(i);
              }
        }
        result+= String.valueOf(count) + prevOne.charAt(i-1);
        return result;
    }
}