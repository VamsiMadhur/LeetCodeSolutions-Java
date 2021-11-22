/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int cchars = 0, readchars = 4;
        char[] buffer = new char[4];
        
        while(cchars < n && readchars == 4) {
            readchars = read4(buffer);
            for(int i=0; i<readchars; i++) {
                if(cchars == n) return cchars;
                buf[cchars] = buffer[i];
                ++cchars;
            }
        }
        return cchars;
        
    }
}