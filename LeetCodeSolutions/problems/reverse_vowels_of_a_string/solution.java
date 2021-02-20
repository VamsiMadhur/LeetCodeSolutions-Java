class Solution {
    public String reverseVowels(String s) {
        if(s==null || s.length()<=1) {
            return s;
        }
        char [] a = s.toCharArray();
        int i =0;
        int j=a.length-1;
        while(i<j) {
            while(i<j && a[i]!='a'&&a[i]!='e'&&a[i]!='i'&&a[i]!='o'&&a[i]!='u'
                         &&a[i]!='A'&&a[i]!='E'&&a[i]!='I'&&a[i]!='O'&&a[i]!='U') {
                i++;
            }
            while(i<j && a[j]!='a'&&a[j]!='e'&&a[j]!='i'&&a[j]!='o'&&a[j]!='u'
                         &&a[j]!='A'&&a[j]!='E'&&a[j]!='I'&&a[j]!='O'&&a[j]!='U') {
                j--;
            }
            if(i<j) {
                char temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            i++;
            j--;
        }
        return new String(a);
    }
}