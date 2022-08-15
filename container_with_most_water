class Solution {
    public int maxArea(int[] ht) { // ht = height
        int n = ht.length;
        int i=0;
        int j=n-1;
        int ans=0;
        int area=0;
        
        while(i<j){
            int width=j-i;
            int len= Math.min(ht[i],ht[j]);
            area = len*width;
            
            ans = Math.max(ans,area);
            
            if(ht[i]>ht[j]){
                j--;
            }
            else{
                i++;
            }
           
        }
        return ans;
    }
}


