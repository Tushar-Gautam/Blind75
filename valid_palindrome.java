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