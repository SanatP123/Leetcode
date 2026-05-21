public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }

        return count;
        
    }

    void dfs(char[][] grid, int r, int c){
        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 || c < 0|| r >= m || c >= n || grid[r][c] == '0'){
            return;
        }

        grid[r][c] = '0';

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public static void main(String[] args) {
        NumberofIslands sol = new NumberofIslands();
        char[][] grid = {{'1','1','1','1','0'},
                         {'1','1','0','1','0'},
                         {'1','1','0','0','0'},
                         {'0','0','0','0','0'}};
        int ans = sol.numIslands(grid);
        System.out.println(ans);

        NumberofIslands sol2 = new NumberofIslands();
        char[][] grid2 = {{'1','1','0','0','0'},
                          {'1','1','0','0','0'},
                          {'0','0','1','0','0'},
                          {'0','0','0','1','1'}};
        int ans2 = sol2.numIslands(grid2);
        System.out.println(ans2);
    }
    
}
