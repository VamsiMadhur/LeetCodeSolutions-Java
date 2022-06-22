class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for(int i=left; i<=right; i++)
            if(sd(i)) 
                result.add(i);
        return result;
    }
    
    public boolean sd(int num) {
        int temp = num, current= num;
        while(current!=0) {
            temp = current%10;
            if(temp == 0 || num%temp != 0) return false;
            current /= 10;
        }
        return true;
    }
}