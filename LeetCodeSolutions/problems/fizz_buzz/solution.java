class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<String>(n);
        for(int i=1; i<=n; i++) {
            String curr = "";
            if(i%3 == 0) {
                curr += "Fizz";
            } 
            if(i%5==0) {
                curr += "Buzz";
            } 
            if(curr.isEmpty()) {
               curr = String.valueOf(i);
            }
             result.add(curr);
        }
        return result;
     }
}