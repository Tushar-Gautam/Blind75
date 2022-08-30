/*      leetcode 54
 Q- Given an m x n matrix, return all elements of the matrix in spiral order.

 Example 1:
    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    Output: [1,2,3,6,9,8,7,4,5]

Example 2:
    Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
    Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 */

//  Solution-
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int minr = 0; //minimum no. of rows in the given matrix
        int maxr = matrix.length-1; //max no. of rows in the given matrix
        int minc = 0; //min coloumn
        int maxc = matrix[0].length-1; //max coloumns
        
        int tne = (m*n); //tne == total number of elements
        int count = 0;
        
        while(count<tne){
            
            if(count<tne){  // if cond. so as to stop repeating of 1 element when loop is on last row
                for(int i=minc;i<=maxc;i++){    // filling top wall
                    ans.add(matrix[minr][i]);
                    count++;
                }   
            }
            minr++; // these changes to min/max of row/col to prevent repeatition of corner cases
            
            if(count<tne){
                for(int i=minr;i<=maxr;i++){ //filling right wall
                    ans.add(matrix[i][maxc]);
                    count++;
                }
            }
            maxc--;
             
            if(count<tne){
                 for(int i=maxc;i>=minc;i--){ //filling bottom wall
                   ans.add(matrix[maxr][i]);
                    count++;
                }   
            }
            maxr--;
            
            if(count<tne){
                 for(int i=maxr;i>=minr;i--){ // filling left wall
                    ans.add(matrix[i][minc]);
                   count++;
                 }
            }
            minc++;
        }
        return ans;
    }
}