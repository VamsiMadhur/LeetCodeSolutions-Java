class Solution {
    public int findNthDigit(int n) {
        int noOfDigits = 1;
        long noOfNumbers = 9;
        int firstNumber = 1;
        while(n>(noOfDigits*noOfNumbers)) {
            n -= (noOfDigits*noOfNumbers);
            noOfDigits++;
            noOfNumbers *= 10;
            firstNumber *= 10;
        }
        int temp = ((n-1)/noOfDigits) + firstNumber;
        
        int x = (n+noOfDigits-1)%noOfDigits;
        int y = noOfDigits- x -1;
        while(y!=0) {
            temp = temp/10;
            y--;
        }
        return temp%10;
    }
}