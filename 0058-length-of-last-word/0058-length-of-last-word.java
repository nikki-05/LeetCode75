class Solution {
    public int lengthOfLastWord(String s) {
        s= s.trim();
        int f=0; //length
        int l= s.length()-1;   //last index
        for(int i=l;i>=0;i--){
            if(s.charAt(i)==' '){
                break;
            }
            f++;
        }
        return f;
    }
}