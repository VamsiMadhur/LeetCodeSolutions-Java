class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int i=0, covered=0;
        double result = 0.0, amount=0.0;
        while(income>0) {
            amount = Math.min(brackets[i][0]-covered, income);
            result += (amount * brackets[i][1])/100.00;
            covered += amount;
            i++;
            income -= amount;
        }
        return result;
    }
}