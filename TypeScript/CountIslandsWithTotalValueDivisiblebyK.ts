// Count Islands With Total Value Divisible by K

// You are given an m x n matrix grid and a positive integer k. An island is a group of positive integers (representing land) that are 4-directionally connected (horizontally or vertically).

// The total value of an island is the sum of the values of all cells in the island.

// Return the number of islands with a total value divisible by k.

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 1000
// 1 <= m * n <= 10**5
// 0 <= grid[i][j] <= 10**6
// 1 <= k <= 10**6
 
function countIslands(grid: number[][], k: number): number {
    const m = grid.length;
    const n = grid[0].length;

    // Track which cells have been visited to avoid counting the same island twice
    const visited = Array.from({length : m}, () => Array(n).fill(false));

    let count = 0;

    // Iterate through every cell in the grid to find island starting points
    for (let r = 0; r < m; r++){
        for (let c = 0; c < n; c++){
            if (grid[r][c] > 0 && !visited[r][c]){
                let total = dfs(r,c);

                // If the island's total value is divisible by k, increment count
                if (total % k === 0){
                    count++;
                }
            }
        }
    }

    // Depth-first search to explore one island and calculate its total value
    function dfs(r : number, c : number) : number {

        // Base case: stop if out of bounds, already visited, or water (value <= 0)
        if (r < 0 || c < 0 || r >= m || c >= n || visited[r][c] || grid[r][c] === 0) {
            return 0;
        }

        visited[r][c] = true;
        
        // Traverse to all directions 
        return grid[r][c] + dfs(r-1,c) + dfs(r+1, c) + dfs(r, c-1) + dfs(r, c+1);
    }

    return count;
    
};



console.log(countIslands([[0,2,1,0,0],[0,5,0,0,5],[0,0,1,0,0],[0,1,4,7,0],[0,2,0,0,8]], 5)); // Output: 2
console.log(countIslands([[3,0,3,0], [0,3,0,3], [3,0,3,0]], 3)); // Output: 6