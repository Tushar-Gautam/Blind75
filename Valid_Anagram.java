/*      Leetcode-242
Q-Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once. 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

Example 2:

Input: s = "rat", t = "car"
Output: false 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 
Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 
 */


//1st way using sorting and equals method
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] s_string = s.toCharArray();
        char[] t_string = t.toCharArray();
        
        Arrays.sort(s_string);
        Arrays.sort(t_string);
        
        return Arrays.equals(s_string,t_string);
    }
}


// 2nd way using freqArray
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null || s.length()!=t.length()){
            return false;
        }
        
        int[] freqArray = new int[26];
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            freqArray[c-'a']++;
        }
        
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            freqArray[c-'a']--;                                        
        }
        
        for(int i:freqArray){
            
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}

//3rd way using Hashmap
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null || s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer> freqMap = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            freqMap.put(c,freqMap.getOrDefault(c,0)+1);
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(freqMap.containsKey(c)){
                if(freqMap.get(c)==1){
                    freqMap.remove(c);
                }
                else{
                     freqMap.put(c,freqMap.getOrDefault(c,0)-1);
                }
            }
            else{
                return false;
            }
        }
        return true;
    }
}
