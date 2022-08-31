/*      Leetcode-1
Q-Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

 */

//using 2 pointers approach
//TC-O(nlogn)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int n = nums.length;
        int lo = 0;
        int hi = n-1;
        
        int[] arr = Arrays.copyOf(nums , nums.length); //copied the original array so that we have original array
        Arrays.sort(arr); //sorting the array so that we can find our sum
        
        while(lo<hi){
            int sum = arr[lo]+arr[hi];
            if(sum==target){
                ans[0] = arr[lo];
                ans[1] = arr[hi];
                break;
            }
            else if(sum>target){ //reducing the sum by moving the hi pointer
                hi--;
            }
            else{
                lo++;
            }
        }
        //we have the values of required number in our ans array now finding their respective indices
        for(int i=0;i<n;i++){
            if(nums[i]==ans[0]){
                ans[0] = i;
                break;
            }
        }
            for(int i=n-1;i>=0;i--){
                if(nums[i]==ans[1]){
                    ans[1] = i;
                    break;
            }
        }
        return ans;
    }
}

//using HashMaps
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>(); // using nums[i] as key and index i as value
        int[] ans = new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                ans[0] = map.get(target-nums[i]);
                ans[1] = i;
                break;
            }
            else{
                map.put(nums[i],i);
            }
        }
          return ans;
    }
}