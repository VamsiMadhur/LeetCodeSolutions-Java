class Solution {
    public String addBinary(String a, String b) {
        StringBuffer result = new StringBuffer();
        int i=a.length()-1;
        int j=b.length()-1;
        char carry = '0';
        while(i>=0 && j>=0) {
            if(a.charAt(i)=='0' && b.charAt(j)=='0') {
                result.append(carry);
                carry = '0';
            } else if(a.charAt(i)=='1' && b.charAt(j)=='0') {
                if(carry == '0') {
                    result.append("1");
                    carry = '0';
                } else {
                    result.append("0");
                    carry = '1';
                }
            } else if(a.charAt(i)=='0' && b.charAt(j)=='1') {
                if(carry == '0') {
                    result.append("1");
                    carry = '0';
                } else {
                    result.append("0");
                    carry = '1';
                }
            } else if(a.charAt(i)=='1' && b.charAt(j)=='1') {
                if(carry == '0') {
                    result.append("0");
                    carry = '1';
                } else {
                    result.append("1");
                    carry = '1';
                }
            }
            i--;
            j--;
        }
        if(i==-1) {
            while(j>=0) {
                if(b.charAt(j)=='0') {
                    result.append(carry);
                    carry = '0';
                } else if(b.charAt(j) == '1') {
                    if(carry == '0') {
                        result.append("1");
                    } else {
                        result.append("0");
                        carry = '1';
                    }
                }
                j--;
            }
        }else if(j==-1) {
            while(i>=0) {
                if(a.charAt(i)=='0') {
                    result.append(carry);
                    carry = '0';
                } else if(a.charAt(i) == '1') {
                    if(carry == '0') {
                        result.append("1");
                    } else {
                        result.append("0");
                        carry = '1';
                    }
                }
                i--;
            }
        }
        
        if(carry == '1') {
            result.append("1");
        }
        return result.reverse().toString();
    }
}