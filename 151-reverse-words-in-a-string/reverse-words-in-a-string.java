class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        s= s.trim();
        s= " "+s;
        StringBuilder words = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--) {
            if(s.charAt(i) == ' ') {
            while(i>0 && s.charAt(i-1) == ' ') {
                i--;
            }
            ans.append(words.reverse());
            ans.append(" ");
            words = new StringBuilder();
            }else{
                words.append(String.valueOf(s.charAt(i)));
            }
        }
        return ans.toString().trim();
    }
}