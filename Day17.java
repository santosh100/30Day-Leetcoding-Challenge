class Solution {
    public static void search(char[][] grid, int row, int col){
        if(row <0 || col <0 || row > grid.length-1 || col > grid[0].length-1 || grid[row][col] == '0')
            return;
        
        grid[row][col] = '0';
        
        search(grid, row + 1, col);
        search(grid, row, col + 1);
        search(grid, row - 1, col);
        search(grid, row , col - 1);
    }
    
    public int numIslands(char[][] grid) {        
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    search(grid, i, j);
                    count++;
                }                    
            }            
        }
        return count;
    }
}