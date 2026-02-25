class Solution {
    public boolean isPalindrome(String s) {
        s= s.toLowerCase();
        StringBuffer sb = new StringBuffer();
        for(char c: s.toCharArray()) {
             if(Character.isLetterOrDigit(c))
                sb.append(c);   
        }
        
        String sf = sb.toString();
        return sf.equals(sb.reverse().toString());
    }
}