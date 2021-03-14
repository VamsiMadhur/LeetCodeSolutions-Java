class Solution {
    public int uniquePaths(int m, int n) {
        m -= 1;
        n -= 1;
        int total = m+n;
        int min = Math.min(m,n);
        if(min == 0) {
            return 1;
        }
        if(min == 1) {
            return total;
        }
        int minNum = total-min+1;
        int result = total;
        int num = total-1;
        int i =2;
        while(num>=minNum) {
            while(i<=min && result%i==0) {
                result/=i;
                i++;
            }
            result *= num;
            num--;
        }
        while(i<=min) {
            result/=i;
            i++;
        }
        return result;
    }
}