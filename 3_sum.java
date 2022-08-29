

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