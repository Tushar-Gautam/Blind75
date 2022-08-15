class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        
        if(n%2!=0)return false;
        
        Stack<Character> st = new Stack<>();
       
        for(int i=0;i<s.length();i++)
            
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                st.push(s.charAt(i));
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                else if(isMatch(st.peek(),s.charAt(i))){
                    st.pop();
                }
                else{
                    return false;
                    //for cases like-->"([}}])"
                }
            }
        return st.empty();
    }
    private  boolean isMatch(char a,char b){
        if(a=='(' && b==')'){
            return true;
        }
        if(a=='[' && b==']'){
            return true;
        }
        if(a=='{' && b=='}'){
            return true;
        }
        return false;
    }
}