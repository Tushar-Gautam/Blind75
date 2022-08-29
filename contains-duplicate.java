
//  TC-O(N) SC-O(N)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int num:nums){
            if(freqMap.containsKey(num)){
                return true;
            }
            else{
                freqMap.put(num,1);
            }
        }
        return false;
    }
}