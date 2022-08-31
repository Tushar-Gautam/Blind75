/*      Leetcode - 121
 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
    
 */

//  Solution-
class Solution {
    public int maxProfit(int[] prices) {
        int minPr = Integer.MAX_VALUE;
        int maxPr = 0;
        
        int n = prices.length;
        for(int i=0;i<n;i++){
            minPr = Math.min(minPr,prices[i]);
            maxPr = Math.max(maxPr,prices[i]-minPr);
        }
        return maxPr;
    }
}