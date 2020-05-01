class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int ansArr[][] = new int[m+1][n+1];
        int max = 0;
        
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                if(matrix[i-1][j-1] == '1'){
                    ansArr[i][j] = 1 + Math.min(ansArr[i-1][j], Math.min(ansArr[i][j-1], ansArr[i-1][j-1]));
                    max = Math.max(max, ansArr[i][j]);  
                }
                 
                System.out.print(ansArr[i][j]+" ");
            }           
            System.out.println();
        }
        return max*max;
    }
}