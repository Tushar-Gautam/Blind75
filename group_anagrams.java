/*      Leetcode- 49
Q-Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:

Input: strs = [""]
Output: [[""]]

Example 3:
    Input: strs = ["a"]
    Output: [["a"]]

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters. 
 */

class Solution {
     public List<List<String>> groupAnagrams(String[] strs) {
         HashMap<HashMap<Character,Integer>,ArrayList<String>> bmap = new HashMap<>();
         
         for(String str:strs){
            
             HashMap<Character,Integer> fmap = new HashMap<>();
             for(int i=0;i<str.length();i++){
                 char ch = str.charAt(i);
                 fmap.put(ch,fmap.getOrDefault(ch,0)+1);
             }
             if(!bmap.containsKey(fmap)){
                 ArrayList<String> list = new ArrayList<>();
                 list.add(str);
                 bmap.put(fmap,list);
             }
             else{
                 ArrayList<String> list = bmap.get(fmap);
                 list.add(str);
             }
         }
         List<List<String>> ans = new ArrayList<>();
         for(List<String> val : bmap.values()){
             ans.add(val);
         }
         return ans;
    }
}
//2nd way
class Solution {

    // TC :O(n*len)
    // SC : O(n)
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String key = buildKey(s);     
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    private String buildKey(String s){
        char[] keyChar = new char[26];
        for (char c : s.toCharArray())  {
            keyChar[c - 'a']++;
        }
        return new String(keyChar);
    }
}