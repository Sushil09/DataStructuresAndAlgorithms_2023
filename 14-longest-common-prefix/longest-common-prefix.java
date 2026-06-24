class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix =strs[0];
        for(int i=1;i<strs.length;i++) {
            prefix = findPrefix(prefix,strs[i]);
        }
        return prefix;
    }

    private static String findPrefix(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Math.min(s1.length(),s2.length());i++) {
            if(s1.charAt(i)==s2.charAt(i)){
                sb.append(s1.charAt(i));
            }else{
               return sb.toString(); 
            }
        }
        return sb.toString();
    }
}