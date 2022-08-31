/*      Leetcode-128
Q-Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
 
 */
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