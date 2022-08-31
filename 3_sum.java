/*      Leetcode 15
Q-  Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(nums);
        
        int n = nums.length;
        for(int i=0;i<n-2;i++){
            
            if (i > 0 && nums[i] == nums[i - 1]) {// skip same result
                continue;
            }   
            
            int left = i+1;
            int right = n-1;
            
            while(left<right){
                
                int sum = nums[i]+nums[left]+nums[right];
            
                if(sum==0){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);   
                    ans.add(temp);
                    
                    left++;
                    right--;
                    //now removing duplicates
                    while(left<right && nums[left]==nums[left-1])left++;
                    while(left<right && nums[right]==nums[right+1]) right--;
                }
                else if(sum>0){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return ans;
    }
}



//this approach gives TLE
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(nums);
        
        int n = nums.length;
        for(int i=0;i<n-2;i++){
            int left = i+1;
            int right = n-1;
            
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                
                if(sum==0){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    if(!ans.contains(temp)){ //due to this part we are just checking all the combinations and not moving to 
                        // other iterations using continue keyword.
                        ans.add(temp);
                    }                   
                    left++;
                    right--;
                }
                else if(sum>0){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return ans;
    }
}