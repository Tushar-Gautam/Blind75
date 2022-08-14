class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int longestStreak = 0;
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(set.contains(num-1)){
              continue;
            }
            int currLen = 0;
            int curr = num;
            while(set.contains(curr)){
                currLen++;
                curr++;
            }
            longestStreak = Math.max(longestStreak,currLen);
        }
        return longestStreak;
    }
}