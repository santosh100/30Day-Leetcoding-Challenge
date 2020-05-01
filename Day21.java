/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        //System.out.println(dim.get(0)+","+dim.get(1));
        int m = dim.get(0);
        int n = dim.get(0);
        int i = 0;
        int j = n-1;
        int indexCol=-1;
        while(i<m && j>-1){
            int value = binaryMatrix.get(i,j);
            if(value == 1){
                indexCol = j;
                j--;
            }else{
                i++;
            }
        }
        
        return indexCol;
    }
}