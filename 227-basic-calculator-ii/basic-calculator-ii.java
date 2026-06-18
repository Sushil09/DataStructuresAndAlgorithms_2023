class Solution {
    public int calculate(String s) {
        int ans = 0;
        char sign ='+';
        int i=0;
        int num =0 ;
        Stack<Integer> st = new Stack<>();
        while(i<s.length()) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 +(c-'0');
            }

            if(!Character.isDigit(c) && c!=' ' || i == s.length()-1){
                if(sign =='+') {
                    st.push(num);
                }else if(sign=='-'){
                    st.push(-num);
                }else if(sign=='*'){
                    st.push(st.pop()* num);
                }else if(sign=='/'){
                    st.push(st.pop()/ num);
                }
                sign=c;
                num=0;
            }
              
            i++;
        }
        while(st.size()>0){
            ans+=st.pop();
        }
        return ans;

    }
}