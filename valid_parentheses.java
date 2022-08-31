/*      Leetcode-20
 Q-Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */

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