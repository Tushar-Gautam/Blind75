/*      Leetcode-238
Q-Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation. 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
//        TC = O(n);
//         SC + O(n);
        
        
        int n = nums.length;
        int[] result = new int[n];
        int[] pre = new int[n];
        int[] suff = new int[n];
        pre[0] =1;
        suff[n-1] =1;
        
        for(int i=1;i<n;i++){
            pre[i] = pre[i-1]*nums[i-1];
        }
        for(int i =n-2;i>=0;i--){
            suff[i] = suff[i+1]*nums[i+1];
        }
        // for(int i =0;i<n;i++){
        //     System.out.print(suff[i]+" ");
        // }
        // System.out.println();
        //  for(int i =0;i<n;i++){
        //     System.out.print(pre[i]+" ");
        // }
        for(int i=0;i<n;i++){
            result[i] = pre[i]*suff[i];
        }
       return result;
    }
}
class Solution {
    public int[] productExceptSelf(int[] nums) {
   // TC = O(N);
   // SC = O(1);
        
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;
        for(int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for(int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }
}
        
        
        
     