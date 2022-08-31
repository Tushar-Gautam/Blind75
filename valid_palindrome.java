/*      Leetcode-125
 Q-A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */
class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int left = 0;
        int right = s.length()-1;
        
        while(left<right){
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            
            if(!((c1>=97 && c1<=122)|| (c1>=48 && c1<=57))){
                left++;
            }
            else if(!((c2>=97 && c2<=122)|| (c2>=48 && c2<=57))){
                right--;
            }
            else{
                if(c1!=c2){
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}