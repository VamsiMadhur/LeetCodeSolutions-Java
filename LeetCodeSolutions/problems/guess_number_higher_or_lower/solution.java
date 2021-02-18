/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        return guessNumber(1,n);
    }
    
    public int guessNumber(int low, int high) {
        int guess = low+ (high-low)/2;
        int val = guess(guess);
        if(val == 0) {
            return guess;
        } else if (val == 1) {
            return guessNumber(guess+1, high);
        } else {
            return guessNumber(low, guess-1);
        }
    }
    
    
}