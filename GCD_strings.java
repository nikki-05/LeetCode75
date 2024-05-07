class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        
        int gcdLen = gcd(len1, len2);
        String gcdStr = str1.substring(0, gcdLen);
        
        if (divides(str1, gcdStr) && divides(str2, gcdStr)) {
            return gcdStr;
        }
        return "";
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private boolean divides(String str, String substr) {
        int n = str.length() / substr.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(substr);
        }
        return sb.toString().equals(str);
    }
}
