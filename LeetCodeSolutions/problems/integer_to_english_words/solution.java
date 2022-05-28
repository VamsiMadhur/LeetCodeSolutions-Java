class Solution {
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        StringBuilder result = new StringBuilder();
        int count=1;
        while(num != 0) {
            int temp = num%1000;            
            if(temp != 0) {
                StringBuilder s = new StringBuilder(" ");
                s.append(convertToString(temp)).append(suffix(count));
                result.insert(0, s);
            }
            num /= 1000;
            count++;
        }
        return result.toString().trim();
    }
    
    public String convertToString(int num) {
        StringBuilder result = new StringBuilder();
        if(num/100 > 0)
            result.append(convertOnes(num/100)).append(" Hundred ");
        num = num%100;
        if(num >= 20)
            result.append(convertTens(num/10)).append(" ").append(convertOnes(num%10));
        else
            result.append(convertOnes(num));
        return result.toString().trim();
    }
    
    public StringBuilder suffix(int num) {
        if(num==1) return new StringBuilder();
        if(num==2) return  new StringBuilder(" Thousand");
        if(num==3)  return  new StringBuilder(" Million");
        if(num==4) return  new StringBuilder(" Billion");
        return  new StringBuilder();
    }
    
    public StringBuilder convertTens(int num) {
        if(num == 2) return new StringBuilder("Twenty");
        if(num == 3) return new StringBuilder("Thirty");
        if(num == 4) return new StringBuilder("Forty");
        if(num == 5) return new StringBuilder("Fifty");
        if(num == 6) return new StringBuilder("Sixty");
        if(num == 7) return new StringBuilder("Seventy");
        if(num == 8) return new StringBuilder("Eighty");
        if(num == 9) return new StringBuilder("Ninety");
        return new StringBuilder();
    }
    
    public StringBuilder convertOnes(int num) {
        if(num == 0) return new StringBuilder();
        if(num == 1) return new StringBuilder("One");
        if(num == 2) return new StringBuilder("Two");
        if(num == 3) return new StringBuilder("Three");
        if(num == 4) return new StringBuilder("Four");
        if(num == 5) return new StringBuilder("Five");
        if(num == 6) return new StringBuilder("Six");
        if(num == 7) return new StringBuilder("Seven");
        if(num == 8) return new StringBuilder("Eight");
        if(num == 9) return new StringBuilder("Nine");
        if(num == 10) return new StringBuilder("Ten");
        if(num == 11) return new StringBuilder("Eleven");
        if(num == 12) return new StringBuilder("Twelve");
        if(num == 13) return new StringBuilder("Thirteen");
        if(num == 14) return new StringBuilder("Fourteen");
        if(num == 15) return new StringBuilder("Fifteen");
        if(num == 16) return new StringBuilder("Sixteen");
        if(num == 17) return new StringBuilder("Seventeen");
        if(num == 18) return new StringBuilder("Eighteen");
        if(num == 19) return new StringBuilder("Nineteen");
        return new StringBuilder();
    }
}